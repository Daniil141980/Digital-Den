package com.example.digitalden.ui.main.favourite;

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
import com.example.digitalden.data.data_sources.room.entites.FavouriteEntity;
import com.example.digitalden.data.data_sources.room.entites.ItemEntity;
import com.example.digitalden.data.models.LeadersSales;
import com.example.digitalden.databinding.RecyclerItemGameBinding;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FavouriteAdapter extends ListAdapter<FavouriteEntity, FavouriteAdapter.FavouriteViewHolder> {
    private OnItemClickListener listenerFav;
    private OnItemClickListener listenerElement;

    public FavouriteAdapter(@NonNull DiffUtil.ItemCallback<FavouriteEntity> diffCallback) {
        super(diffCallback);
    }

    public void setListenerFav(OnItemClickListener listenerFav) {
        this.listenerFav = listenerFav;
    }

    public void setListenerElement(OnItemClickListener listenerElement) {
        this.listenerElement = listenerElement;
    }

    @Override
    public FavouriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerItemGameBinding binding = RecyclerItemGameBinding.inflate(inflater, parent, false);
        return new FavouriteViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(FavouriteViewHolder holder, int position) {
        FavouriteEntity current = getItem(position);
        String gameName  = current.getNameGame();
        if (gameName.length() > 25) {
            holder.binding.titleGame.setText(gameName.substring(0, 25));
        }
        else {
            holder.binding.titleGame.setText(gameName);
        }
        holder.binding.buyBtn.setText("SALE " + current.getSalePercent() +"%");
        holder.binding.basePrice.setText("Базовая цена:  " + current.getBasePrice() / 100 +" Р");
        LiveData<Bitmap> liveData = getImage(current.getImgUrl());
        liveData.observeForever(new Observer<Bitmap>() {
            @Override
            public void onChanged(Bitmap bitmap) {
                holder.binding.imageGame.setImageBitmap(bitmap);
                liveData.removeObserver(this);
            }
        });
        holder.binding.favouriteBtn.setImageResource(R.drawable.favorite_for_click_abled);

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

    static class WordDiff extends DiffUtil.ItemCallback<FavouriteEntity> {

        @Override
        public boolean areItemsTheSame(@NonNull FavouriteEntity oldItem, @NonNull FavouriteEntity newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull FavouriteEntity oldItem, @NonNull FavouriteEntity newItem) {
            return oldItem.getIdGame().equals(newItem.getIdGame());
        }
    }

    public interface OnItemClickListener {
        void onClick(FavouriteEntity element);
    }

    static class FavouriteViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerItemGameBinding binding;

        private FavouriteViewHolder(View itemView) {
            super(itemView);
            binding = RecyclerItemGameBinding.bind(itemView);

        }

    }
}
