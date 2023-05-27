package com.example.digitalden.ui.main.freeGame;

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
import com.example.digitalden.data.models.FreeGames.Data.Catalog.SearchStore.Elements;
import com.example.digitalden.data.models.LeadersSales;
import com.example.digitalden.databinding.RecyclerItemGameBinding;
import com.example.digitalden.ui.main.mainPage.MainPageAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class FreeGiveawaysAdapter extends ListAdapter<Elements, FreeGiveawaysAdapter.FreeGiveawaysViewHolder> {
    private OnItemClickListener listenerElement;

    public FreeGiveawaysAdapter(@NonNull DiffUtil.ItemCallback<Elements> diffCallback) {
        super(diffCallback);
    }

    public void setListenerElement(OnItemClickListener listenerElement) {
        this.listenerElement = listenerElement;
    }

    @Override
    public FreeGiveawaysViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerItemGameBinding binding = RecyclerItemGameBinding.inflate(inflater, parent, false);
        return new FreeGiveawaysAdapter.FreeGiveawaysViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(FreeGiveawaysViewHolder holder, int position) {
        Elements current = getItem(position);
        String gameName  = current.getTitle();
        if (gameName.length() > 25) {
            holder.binding.titleGame.setText(gameName.substring(0, 25));
        }
        else {
            holder.binding.titleGame.setText(gameName);
        }
        holder.binding.buyBtn.setText("SALE 100%");
        holder.binding.basePrice.setText("Раздача EGS");
        LiveData<Bitmap> liveData = getImage(current.getKeyImages().get(0).getUrl());
        liveData.observeForever(new Observer<Bitmap>() {
            @Override
            public void onChanged(Bitmap bitmap) {
                holder.binding.imageGame.setImageBitmap(bitmap);
                liveData.removeObserver(this);
            }
        });
        holder.binding.favouriteBtn.setVisibility(View.GONE);


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

    static class WordDiff extends DiffUtil.ItemCallback<Elements> {

        @Override
        public boolean areItemsTheSame(@NonNull Elements oldItem, @NonNull Elements newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Elements oldItem, @NonNull Elements newItem) {
            return oldItem.getId().equals(newItem.getId());
        }
    }


    public interface OnItemClickListener {
        void onClick(Elements element);
    }

    static class FreeGiveawaysViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerItemGameBinding binding;

        private FreeGiveawaysViewHolder(View itemView) {
            super(itemView);
            binding = RecyclerItemGameBinding.bind(itemView);

        }

    }

}
