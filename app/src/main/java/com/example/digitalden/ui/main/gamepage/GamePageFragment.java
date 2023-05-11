package com.example.digitalden.ui.main.gamepage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.digitalden.R;
import com.example.digitalden.databinding.FragmentGamePageBinding;
import com.example.digitalden.ui.main.gamepage.GamePageViewModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GamePageFragment extends Fragment {
    private FragmentGamePageBinding binding;
    private GamePageViewModel viewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(GamePageViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        binding = FragmentGamePageBinding.inflate(inflater, container, false);
        binding.nameGame.setText(bundle.getString("name_game"));
        binding.steamPrice.setText(bundle.getString("price") + "Р");
        LiveData<Bitmap> liveData = getImage(bundle.getString("url"));
        liveData.observeForever(new Observer<Bitmap>() {
            @Override
            public void onChanged(Bitmap bitmap) {
                binding.imageGame.setImageBitmap(bitmap);
                liveData.removeObserver(this);
            }
        });
        binding.steamBuyBtn.setOnClickListener(v -> {
            String ur = "https://store.steampowered.com/app/" + bundle.getString("url_game");
            Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(ur));
        v.getContext().startActivity(intent);});;
        binding.backBtn.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_gamePageFragment_to_mainPageFragment);});
        return binding.getRoot();
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
}
