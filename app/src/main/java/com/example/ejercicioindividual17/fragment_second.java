package com.example.ejercicioindividual17;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejercicioindividual17.databinding.FragmentSecondBinding;


public class fragment_second extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSecondBinding.inflate(inflater,container,false);
        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null){
            String palabra = bundle.getString("palabra");
            binding.txtSecondFragment.setText(palabra);
            binding.floatingActionButton2.setVisibility(View.VISIBLE);
            // Ocultar el FAB al abrir el FragmentSecond
            MainActivity mainActivity = (MainActivity) requireActivity();
            mainActivity.hideFloatingActionButton();
        }
    }


}