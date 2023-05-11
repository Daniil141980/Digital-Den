package com.example.digitalden.ui.main.mainPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalden.R;
import com.example.digitalden.data.models.LeadersSales;
import com.example.digitalden.databinding.FragmentMainPageBinding;
import com.example.digitalden.data.models.Item;
import com.example.digitalden.data.repositories.ItemsRepository;
import com.example.digitalden.ui.main.mainPage.MainPageAdapter;
import com.example.digitalden.ui.main.mainPage.MainPageViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainPageFragment extends Fragment {
    private FragmentMainPageBinding binding;
    private MainPageViewModel viewModel;
    MainPageAdapter adapter;

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

        adapter = new MainPageAdapter(new MainPageAdapter.WordDiff());
        adapter.setListenerElement(element -> {
            Bundle bundle = new Bundle();
            bundle.putString("name_game", element.getName());
            int price = element.getFinal_price() / 100;
            bundle.putString("price", Integer.toString(price));
            bundle.putString("url", element.getHeader_image());
            bundle.putString("url_game", Integer.toString(element.getId()));
            NavHostFragment.findNavController(this).navigate(R.id.action_mainPageFragment_to_gamePageFragment, bundle);
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


        // Update the cached copy of the words in the adapter.
        viewModel.getAllGames().observe(getViewLifecycleOwner(), games -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(games.getTop_sellers().getItems());
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
