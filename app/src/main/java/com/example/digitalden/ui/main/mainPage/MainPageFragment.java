package com.example.digitalden.ui.main.mainPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalden.R;
import com.example.digitalden.data.data_sources.room.entites.FavouriteEntity;
import com.example.digitalden.databinding.FragmentMainPageBinding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainPageFragment extends Fragment {
    private FragmentMainPageBinding binding;
    private MainPageViewModel viewModel;
    private MainPageAdapter adapter;
    private MainPageSearchAdapter adapterSearch;
    private Set<String> gameNameSet;
    RecyclerView recyclerView;
    SearchView searchView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainPageViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainPageBinding.inflate(inflater);
        binding.sortingBtn.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_mainPageFragment_to_sortingMainFragment);});

        recyclerView = binding.gamesRecycler;
        gameNameSet = new HashSet<>();
        viewModel.getGameFromDatabase().observe(getViewLifecycleOwner(), games->{
            for (FavouriteEntity i: games) {
                gameNameSet.add(i.getNameGame());
            }
            adapter.setGameName(gameNameSet);
        });

        adapter = new MainPageAdapter(new MainPageAdapter.WordDiff());
        adapterSearch = new MainPageSearchAdapter(new MainPageSearchAdapter.WordDiff());

        adapter.setListenerElement(element -> {
            Bundle bundle = new Bundle();
            bundle.putString("name_game", element.getName());
            int price = element.getFinal_price() / 100;
            bundle.putString("price", Integer.toString(price));
            bundle.putString("url", element.getHeader_image());
            bundle.putInt("id", element.getId());
            bundle.putInt("where", 1);
            NavHostFragment.findNavController(this).navigate(R.id.action_mainPageFragment_to_gamePageFragment, bundle);
        });


        adapter.setListenerFav((flag, element) -> {
            FavouriteEntity game = new FavouriteEntity(element.getName().toLowerCase(), element.getId(), element.getHeader_image(),
                    Integer.toString(element.getDiscount_percent()), element.getOriginal_price());
            if (flag){
                viewModel.delete(game);
            } else {
                viewModel.insert(game);
            }

        });

        viewModel.getAllGames().observe(getViewLifecycleOwner(), games -> {
            adapter.submitList(games.getSpecials().getItems());
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


        searchView = binding.searchGame;
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterRecycle(newText);
                return true;
            }
        });

        return binding.getRoot();
    }

    private void filterRecycle(String text) {
        if (text.isEmpty()){
            binding.gamesRecycler.setAdapter(adapter);
            return;
        }
        adapterSearch.setListenerElement(element -> {
            Bundle bundle = new Bundle();
            bundle.putString("name_game", element.getTitle());
            String price = element.getPrice().getFinalAmount();
            bundle.putString("price", price);
            bundle.putString("url", "https:" + element.getImage() + ".jpg");
            bundle.putInt("id", element.getId());
            bundle.putInt("where", 1);
            NavHostFragment.findNavController(this).navigate(R.id.action_mainPageFragment_to_gamePageFragment, bundle);
        });
        adapterSearch.setGameName(gameNameSet);

        adapterSearch.setListenerFav((flag, element) -> {
            FavouriteEntity game = new FavouriteEntity(element.getTitle().toLowerCase(), element.getId(),
                    "https:" + element.getImage() + ".jpg",
                    Integer.toString(element.getPrice().getDiscountPercentage()), Integer.parseInt(element.getPrice().getBaseAmount()));
            if (flag){
                viewModel.delete(game);
            } else {
                viewModel.insert(game);
            }
        });
        viewModel.setGameFromGogLiveData(text);

        viewModel.getGameFromGogLiveData().observe(getViewLifecycleOwner(), games -> {
            adapterSearch.submitList(games.getProducts());
        });

        recyclerView.setAdapter(adapterSearch);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        gameNameSet = new HashSet<>();
        viewModel.getGameFromDatabase().observe(getViewLifecycleOwner(), games->{
            for (FavouriteEntity i: games) {
                gameNameSet.add(i.getNameGame());
            }
            adapter.setGameName(gameNameSet);
            adapterSearch.setGameName(gameNameSet);
        });
    }
}
