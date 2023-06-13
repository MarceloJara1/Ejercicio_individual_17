package com.example.ejercicioindividual17;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejercicioindividual17.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements WordAdapter.OnItemClickListener{

    private FragmentFirstBinding binding;
    private List<String> dataList = new ArrayList<>();
    private WordAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater,container, false);
        View view = binding.getRoot();

        return view;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        adapter = new WordAdapter(wordListAutoGenerate());
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setHasFixedSize(true);
        adapter.setItemClickListener(this);
    }

    private List<String> wordListAutoGenerate(){
        if (dataList.isEmpty()) {
            for (int i = 1; i < 5; i++) {
                dataList.add("Palabra " + i);
            }
        }
        return dataList;
    }
    public void agregarElemento(){
        String palabra = "Palabra " + (dataList.size() + 1);
        dataList.add(palabra);
        if (adapter != null){
            adapter.notifyItemInserted(dataList.size()-1);
            binding.recyclerView.smoothScrollToPosition(dataList.size());
        }
    }

    @Override
    public void onItemClick(String palabra){
        fragment_second secondFragment = new fragment_second();
        Bundle bundle = new Bundle();
        bundle.putString("palabra",palabra);
        secondFragment.setArguments(bundle);

        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, secondFragment)
                .addToBackStack(null)
                .commit();


        int selectedPosition = dataList.indexOf(palabra);
        String selectedWord = dataList.get(selectedPosition);
            if (!selectedWord.contains(" --Clickeada--")) {
                String updateWord = palabra + " --Clickeada--";
                dataList.set(selectedPosition, updateWord);
                adapter.notifyItemChanged(selectedPosition);
            }

    }


}