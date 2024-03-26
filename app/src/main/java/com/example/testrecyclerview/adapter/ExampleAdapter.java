package com.example.testrecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testrecyclerview.R;
import com.example.testrecyclerview.databinding.ExampleItemBinding;
import com.example.testrecyclerview.model.ExampleItem;

import java.util.ArrayList;
import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private List<ExampleItem> list = new ArrayList<>();

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View newView = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,
                parent, false);
        return new ExampleViewHolder(newView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        private ExampleItemBinding exampleItemBinding;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            exampleItemBinding = ExampleItemBinding.bind(itemView);
        }

        public void bind(ExampleItem exampleItem){
            exampleItemBinding.name.setText(exampleItem.getName());
            exampleItemBinding.price.setText(String.valueOf(exampleItem.getPrice()));
        }
    }



    public void Add(ExampleItem exampleItem){
        list.add(exampleItem);
        notifyDataSetChanged();
    }

    public void Clear(){
        list.clear();
        notifyDataSetChanged();
    }
}
