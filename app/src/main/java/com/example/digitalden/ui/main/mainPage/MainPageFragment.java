package com.example.digitalden.ui.main.mainPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    private Set<Integer> gameId;

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

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

        RecyclerView recyclerView = binding.gamesRecycler;
        gameId = new HashSet<Integer>();
        viewModel.getGameFromDatabase().observe(getViewLifecycleOwner(), games->{
            for (FavouriteEntity i: games) {
                gameId.add(i.getIdGame());
            }

        });

        adapter = new MainPageAdapter(new MainPageAdapter.WordDiff());
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
        adapter.setGameId(gameId);

        adapter.setListenerFav(element -> {
            FavouriteEntity game = new FavouriteEntity(element.getName(), element.getId(), element.getHeader_image(),
                    Integer.toString(element.getDiscount_percent()), element.getOriginal_price());
            if (gameId.contains(element.getId())){
                viewModel.delete(game);
            } else {
                viewModel.insert(game);
            }

        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


        viewModel.getAllGames().observe(getViewLifecycleOwner(), games -> {
            adapter.submitList(games.getSpecials().getItems());
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
