package com.example.digitalden.ui.main.mainPage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalden.R;

class MainPageViewHolder extends RecyclerView.ViewHolder {
    private final TextView wordItemView;

    private MainPageViewHolder(View itemView) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.title_game);
    }

    public void bind(String text) {
        wordItemView.setText(text);
    }

    static MainPageViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_game, parent, false);
        return new MainPageViewHolder(view);
    }
}
