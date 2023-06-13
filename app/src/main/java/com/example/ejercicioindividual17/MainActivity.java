package com.example.ejercicioindividual17;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;


import android.os.Bundle;
import android.view.View;

import com.example.ejercicioindividual17.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);

                if (navHostFragment!=null){
                    Fragment fragment = navHostFragment.getChildFragmentManager().getFragments().get(0);
                    if (fragment instanceof  FirstFragment){
                        FirstFragment firstFragment = (FirstFragment) fragment;
                        firstFragment.agregarElemento();
                    }
                }
            }
        });

        binding.floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                binding.floatingActionButton.setVisibility(View.VISIBLE);
                binding.floatingActionButton2.setVisibility(View.GONE);
            }
        });
    }

    public void hideFloatingActionButton() {
        binding.floatingActionButton.setVisibility(View.GONE);
        binding.floatingActionButton2.setVisibility(View.VISIBLE);
    }
}