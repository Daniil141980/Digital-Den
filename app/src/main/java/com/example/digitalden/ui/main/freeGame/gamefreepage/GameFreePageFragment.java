package com.example.digitalden.ui.main.freeGame.gamefreepage;

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
import com.example.digitalden.databinding.FragamentGamePageFreeBinding;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class GameFreePageFragment extends Fragment {
    private FragamentGamePageFreeBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        binding = FragamentGamePageFreeBinding.inflate(inflater);
        binding.nameGame.setText(bundle.getString("name_game"));
        LiveData<Bitmap> liveData = getImage(bundle.getString("url_img"));
        liveData.observeForever(new Observer<Bitmap>() {
            @Override
            public void onChanged(Bitmap bitmap) {
                binding.imageGame.setImageBitmap(bitmap);
                liveData.removeObserver(this);
            }
        });
        binding.aboutGame.setText(bundle.getString("description"));

        binding.egsBuyBtn.setOnClickListener(v -> {
            String ur = "https://store.epicgames.com/ru/p/" + bundle.getString("url");
            Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(ur));
            v.getContext().startActivity(intent);});
        binding.backBtn.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_freeGiveawaysPageFragment_to_freeGiveawaysFragment);
        });

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
