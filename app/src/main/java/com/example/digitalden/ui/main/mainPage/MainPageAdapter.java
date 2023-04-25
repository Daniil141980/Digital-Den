package com.example.digitalden.ui.main.mainPage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalden.data.data_sources.room.entites.ItemEntity;
import com.example.digitalden.data.models.Item;
import com.example.digitalden.databinding.RecyclerItemGameBinding;

import java.util.ArrayList;
import java.util.List;

public class MainPageAdapter extends ListAdapter<ItemEntity, MainPageViewHolder> {

    public MainPageAdapter(@NonNull DiffUtil.ItemCallback<ItemEntity> diffCallback) {
        super(diffCallback);
    }

    @Override
    public MainPageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return MainPageViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(MainPageViewHolder holder, int position) {
        ItemEntity current = getItem(position);
        holder.bind(current.getNameGame());
    }

    static class WordDiff extends DiffUtil.ItemCallback<ItemEntity> {

        @Override
        public boolean areItemsTheSame(@NonNull ItemEntity oldItem, @NonNull ItemEntity newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ItemEntity oldItem, @NonNull ItemEntity newItem) {
            return oldItem.getNameGame().equals(newItem.getNameGame());
        }
    }

}
