package com.example.digitalden.ui.main.mainPage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalden.R;
import com.example.digitalden.data.models.GameFromGog.Products;
import com.example.digitalden.databinding.RecyclerItemGameBinding;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class MainPageSearchAdapter extends ListAdapter<Products, MainPageSearchAdapter.MainPageSearchViewHolder> {
    private OnItemClickListenerFav listenerFav;
    private OnItemClickListener listenerElement;
    private Set<String> gameNameSet = new HashSet<>();

    public void setGameName(Set<String> gameNameSet) {
        this.gameNameSet = gameNameSet;
        notifyDataSetChanged();
    }

    public MainPageSearchAdapter(@NonNull DiffUtil.ItemCallback<Products> diffCallback) {
        super(diffCallback);
    }

    public void setListenerFav(OnItemClickListenerFav listenerFav) {
        this.listenerFav = listenerFav;
    }

    public void setListenerElement(OnItemClickListener listenerElement) {
        this.listenerElement = listenerElement;
    }

    @Override
    public MainPageSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerItemGameBinding binding = RecyclerItemGameBinding.inflate(inflater, parent, false);
        return new MainPageSearchViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(MainPageSearchViewHolder holder, int position) {
        Products current = getItem(position);
        String gameName  = current.getTitle();
        if (gameName.length() > 22) {
            holder.binding.titleGame.setText(gameName.substring(0, 22));
        }
        else {
            holder.binding.titleGame.setText(gameName);
        }
        holder.binding.buyBtn.setText("SALE " + current.getPrice().getDiscountPercentage() + "%");
        holder.binding.basePrice.setText("Базовая цена:  " + current.getPrice().getBaseAmount() + " ₽");
        LiveData<Bitmap> liveData = getImage("https:" + current.getImage() + ".jpg");
        liveData.observeForever(new Observer<Bitmap>() {
            @Override
            public void onChanged(Bitmap bitmap) {
                holder.binding.imageGame.setImageBitmap(bitmap);
                liveData.removeObserver(this);
            }
        });
        if (gameNameSet.contains(current.getTitle().toLowerCase())){
            holder.binding.favouriteBtn.setImageResource(R.drawable.favorite_in);
        } else {
            holder.binding.favouriteBtn.setImageResource(R.drawable.favorite_out);
        }
        holder.binding.recyclerItem.setOnClickListener(v -> {
            if (listenerElement != null) {
                listenerElement.onClick(current);
            }
        });
        holder.binding.buyBtn.setOnClickListener(v -> {
            if (listenerElement != null) {
                listenerElement.onClick(current);
            }
        });
        holder.binding.favouriteBtn.setOnClickListener(v -> {
            if (listenerFav != null) {
                listenerFav.onClick(gameNameSet.contains(current.getTitle().toLowerCase()), current);
                if (gameNameSet.contains(current.getTitle().toLowerCase())){
                    holder.binding.favouriteBtn.setImageResource(R.drawable.favorite_out);
                    gameNameSet.remove(current.getTitle().toLowerCase());
                } else {
                    holder.binding.favouriteBtn.setImageResource(R.drawable.favorite_in);
                    gameNameSet.add(current.getTitle().toLowerCase());
                }
            }
        });

    }

    public LiveData<Bitmap> getImage(String imageUrl) {
        MutableLiveData<Bitmap> liveData = new MutableLiveData<>();
        new Thread(() -> {
            try {
                URL url = new URL(imageUrl);
                InputStream content = (InputStream) url.getContent();
                Bitmap bitmap = BitmapFactory.decodeStream(content);
                liveData.postValue(bitmap);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
        return liveData;
    }

    static class WordDiff extends DiffUtil.ItemCallback<Products> {

        @Override
        public boolean areItemsTheSame(@NonNull Products oldItem, @NonNull Products newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Products oldItem, @NonNull Products newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    }


    public interface OnItemClickListener {
        void onClick(Products element);
    }

    public interface OnItemClickListenerFav {
        void onClick(boolean flag, Products element);
    }

    static class MainPageSearchViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerItemGameBinding binding;

        private MainPageSearchViewHolder(View itemView) {
            super(itemView);
            binding = RecyclerItemGameBinding.bind(itemView);

        }

    }

}
