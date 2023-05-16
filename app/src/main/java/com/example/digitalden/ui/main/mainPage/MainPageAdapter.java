package com.example.digitalden.ui.main.mainPage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalden.R;
import com.example.digitalden.data.data_sources.room.entites.FavouriteEntity;
import com.example.digitalden.data.data_sources.room.entites.ItemEntity;
import com.example.digitalden.data.models.Item;
import com.example.digitalden.data.models.LeadersSales;
import com.example.digitalden.data.models.LeadersSales.Specials.Items;
import com.example.digitalden.data.models.OneGame;
import com.example.digitalden.databinding.RecyclerItemGameBinding;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainPageAdapter extends ListAdapter<Items, MainPageAdapter.MainPageViewHolder> {
    private OnItemClickListener listenerFav;
    private OnItemClickListener listenerElement;
    private LiveData<List<FavouriteEntity>> gameFromDatabase;
    private Set<Integer> gameId;

    public void setGameId(Set<Integer> gameId) {
        this.gameId = gameId;
    }

    public MainPageAdapter(@NonNull DiffUtil.ItemCallback<Items> diffCallback) {
        super(diffCallback);
    }

    public void setListenerFav(OnItemClickListener listenerFav) {
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
        if (gameName.length() > 25) {
            holder.binding.titleGame.setText(gameName.substring(0, 25));
        }
        else {
            holder.binding.titleGame.setText(gameName);
        }
        holder.binding.buyBtn.setText("SALE " + current.getDiscount_percent() +"%");
        holder.binding.basePrice.setText("Базовая цена:  " + current.getOriginal_price() / 100 +" Р");
        LiveData<Bitmap> liveData = getImage(current.getHeader_image());
        liveData.observeForever(new Observer<Bitmap>() {
            @Override
            public void onChanged(Bitmap bitmap) {
                holder.binding.imageGame.setImageBitmap(bitmap);
                liveData.removeObserver(this);
            }
        });
        if (gameId.contains(current.getId())){
            holder.binding.favouriteBtn.setImageResource(R.drawable.favorite_for_click_abled);
        } else {
            holder.binding.favouriteBtn.setImageResource(R.drawable.favorite_for_click_disabled);
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
                listenerFav.onClick(current);
                if (gameId.contains(current.getId())){
                    holder.binding.favouriteBtn.setImageResource(R.drawable.favorite_for_click_disabled);
                } else {
                    holder.binding.favouriteBtn.setImageResource(R.drawable.favorite_for_click_abled);
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

    static class MainPageViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerItemGameBinding binding;

        private MainPageViewHolder(View itemView) {
            super(itemView);
            binding = RecyclerItemGameBinding.bind(itemView);

        }

    }

}
