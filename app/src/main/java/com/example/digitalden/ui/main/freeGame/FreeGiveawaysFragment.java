package com.example.digitalden.ui.main.freeGame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalden.R;
import com.example.digitalden.data.data_sources.room.entites.FavouriteEntity;
import com.example.digitalden.databinding.FragmentFreeGiveawaysBinding;
import com.example.digitalden.databinding.FragmentMainPageBinding;
import com.example.digitalden.ui.main.mainPage.MainPageAdapter;
import com.example.digitalden.ui.main.mainPage.MainPageViewModel;

import java.util.HashSet;

public class FreeGiveawaysFragment extends Fragment {
    private FragmentFreeGiveawaysBinding binding;
    private FreeGiveawaysViewModel viewModel;
    private FreeGiveawaysAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel =  new ViewModelProvider(this).get(FreeGiveawaysViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFreeGiveawaysBinding.inflate(inflater);

        RecyclerView recyclerView = binding.gamesRecycler;

        adapter = new FreeGiveawaysAdapter(new FreeGiveawaysAdapter.WordDiff());
        adapter.setListenerElement(element -> {
            Bundle bundle = new Bundle();
            bundle.putString("name_game", element.getTitle());
            String url = "";
            for (int i = 0; i < element.getCustomAttributes().size(); i++) {
                if (element.getCustomAttributes().get(i).getKey().contains("productSlug")) {
                    url = element.getCustomAttributes().get(i).getValue();
                }
            }
            bundle.putString("url", url);
            bundle.putString("url_img", element.getKeyImages().get(0).getUrl());
            bundle.putString("description", element.getDescription());
            NavHostFragment.findNavController(this).navigate(R.id.action_freeGiveawaysFragment_to_freeGiveawaysPageFragment, bundle);
        });


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


        viewModel.getFreeGames().observe(getViewLifecycleOwner(), games -> {
            adapter.submitList(games.getData().getCatalog().getSearchStore().getElements());
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
