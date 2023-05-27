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
import com.example.digitalden.data.models.LeadersSales.Specials.Items;
import com.example.digitalden.databinding.RecyclerItemGameBinding;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class MainPageAdapter extends ListAdapter<Items, MainPageAdapter.MainPageViewHolder> {
    private OnItemClickListenerFav listenerFav;
    private OnItemClickListener listenerElement;
    private Set<String> gameNameSet = new HashSet<>();

    public void setGameName(Set<String> gameName) {
        this.gameNameSet = gameName;
        notifyDataSetChanged();
    }

    public MainPageAdapter(@NonNull DiffUtil.ItemCallback<Items> diffCallback) {
        super(diffCallback);
    }

    public void setListenerFav(OnItemClickListenerFav listenerFav) {
        this.listenerFav = listenerFav;
    }

    public void setListenerElement(OnItemClickListener listenerElement) {
        this.listenerElement = listenerElement;
    }

    @Override
    public MainPageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerItemGameBinding binding = RecyclerItemGameBinding.inflate(inflater, parent, false);
        return new MainPageViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(MainPageViewHolder holder, int position) {
        Items current = getItem(position);
        String gameName  = current.getName();
        if (gameName.length() > 22) {
            holder.binding.titleGame.setText(gameName.substring(0, 22));
        }
        else {
            holder.binding.titleGame.setText(gameName);
        }
        holder.binding.buyBtn.setText("SALE " + current.getDiscount_percent() + "%");
        holder.binding.basePrice.setText("Базовая цена:  " + current.getOriginal_price() / 100 + " ₽");
        LiveData<Bitmap> liveData = getImage(current.getHeader_image());
        liveData.observeForever(new Observer<Bitmap>() {
            @Override
            public void onChanged(Bitmap bitmap) {
                holder.binding.imageGame.setImageBitmap(bitmap);
                liveData.removeObserver(this);
            }
        });
        if (gameNameSet.contains(current.getName().toLowerCase())){
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
                listenerFav.onClick(gameNameSet.contains(current.getName().toLowerCase()), current);
                if (gameNameSet.contains(current.getName().toLowerCase())){
                    holder.binding.favouriteBtn.setImageResource(R.drawable.favorite_out);
                    gameNameSet.remove(current.getName().toLowerCase());
                } else {
                    holder.binding.favouriteBtn.setImageResource(R.drawable.favorite_in);
                    gameNameSet.add(current.getName().toLowerCase());
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

    static class WordDiff extends DiffUtil.ItemCallback<Items> {

        @Override
        public boolean areItemsTheSame(@NonNull Items oldItem, @NonNull Items newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Items oldItem, @NonNull Items newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }


    public interface OnItemClickListener {
        void onClick(Items element);
    }

    public interface OnItemClickListenerFav {
        void onClick(boolean flag, Items element);
    }

    static class MainPageViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerItemGameBinding binding;

        private MainPageViewHolder(View itemView) {
            super(itemView);
            binding = RecyclerItemGameBinding.bind(itemView);

        }

    }

}
