package com.example.testrecyclerview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testrecyclerview.adapter.ExampleAdapter;
import com.example.testrecyclerview.model.ExampleItem;

public class FirstFragment extends Fragment {
    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_first, container, false);

        RecyclerView friendsRV = root.findViewById(R.id.rv_example);
        friendsRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        ExampleAdapter friendAdapter = new ExampleAdapter();
        friendAdapter.Add(new ExampleItem("Gugugaga", 1509));
        friendAdapter.Add(new ExampleItem("Privet vsem", 7777));

        friendsRV.setAdapter(friendAdapter);
        return root;
    }
}