package com.example.ejercicioindividual17;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicioindividual17.databinding.DataListItemBinding;

import java.util.List;
import java.util.concurrent.RecursiveAction;

    public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

        private final List<String> wordList;

        public WordAdapter(List<String> wordList) {
            this.wordList = wordList;
        }

        private OnItemClickListener itemClickListener;

        public void setItemClickListener(OnItemClickListener listener) {
            this.itemClickListener = listener;
        }

        @NonNull
        @Override
        public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            DataListItemBinding binding = DataListItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
            return new WordViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
            String word = wordList.get(position);
            holder.textView.setText(word);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener!=null){
                        itemClickListener.onItemClick(word);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return wordList.size();
        }

    public class WordViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        public  WordViewHolder(@NonNull DataListItemBinding binding){
            super(binding.getRoot());
            textView = binding.txtView;
        }

    }

    public  interface OnItemClickListener{
            void onItemClick(String word);
    }

}
