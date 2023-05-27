package com.example.digitalden.ui.main.favourite;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.digitalden.R;
import com.example.digitalden.data.data_sources.room.entites.FavouriteEntity;
import com.example.digitalden.databinding.FragmentFavouriteBinding;

public class FavouriteFragment extends Fragment {
    private FragmentFavouriteBinding binding;
    private FavouriteViewModel viewModel;
    private FavouriteAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(FavouriteViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFavouriteBinding.inflate(inflater);
        RecyclerView recyclerView = binding.gamesRecycler;
        adapter = new FavouriteAdapter(new FavouriteAdapter.WordDiff());

        adapter.setListenerElement(element -> {
            Bundle bundle = new Bundle();
            bundle.putString("name_game", element.getNameGame());
            int price = element.getBasePrice() / 100;
            bundle.putString("price", Integer.toString(price));
            bundle.putString("url", element.getImgUrl());
            bundle.putInt("id", element.getIdGame());
            bundle.putInt("where", 2);
            NavHostFragment.findNavController(this).navigate(R.id.action_favouriteFragment_to_gamePageFragment, bundle);
        });

        adapter.setListenerFav(element -> {
            FavouriteEntity game = new FavouriteEntity(element.getNameGame().toLowerCase(), element.getIdGame(), element.getImgUrl(),
                    element.getSalePercent(), element.getBasePrice());
            viewModel.delete(game);
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        viewModel.getAllGames().observe(getViewLifecycleOwner(), games -> {
            adapter.submitList(games);
        });
        return binding.getRoot();
    }

}
