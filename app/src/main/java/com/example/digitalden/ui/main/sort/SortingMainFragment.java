package com.example.digitalden.ui.main.sort;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.digitalden.R;
import com.example.digitalden.databinding.FragmentSortingBinding;

public class SortingMainFragment extends Fragment {
    private FragmentSortingBinding binding;
    private SortingMainViewModel viewModel;
    private Spinner spinner;
    ArrayAdapter<String> adapter;
    private String[] arrayGenres = {"Жанры", "simulation", "action", "role-playing", "shooter", "strategy", "adventure", "sports", "racing"};
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SortingMainViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSortingBinding.inflate(inflater);
        binding.backBtn.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_sortMainFragment_to_mainPageFragment);});
        spinner = binding.genre;

        adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, arrayGenres);
        int position = adapter.getPosition(viewModel.getGenre());
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setSelection(position);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos,
                                       long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.sea_100));
                ((TextView) parent.getChildAt(0)).setTextSize(32);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        binding.searchBtn.setOnClickListener(v -> {
            String select = spinner.getSelectedItem().toString();
            viewModel.setGenre(select);
            Bundle bundle = new Bundle();
            bundle.putString("genre", spinner.getSelectedItem().toString());
            NavHostFragment.findNavController(this).navigate(R.id.action_sortMainFragment_to_mainPageFragment, bundle);
        });
        return binding.getRoot();
    }
}
