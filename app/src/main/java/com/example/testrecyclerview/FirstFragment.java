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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FirstFragment extends Fragment {
    ExampleAdapter friendAdapter;
    private Executor executor = Executors.newSingleThreadExecutor();

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

        friendAdapter = new ExampleAdapter();
//        friendAdapter.Add(new ExampleItem("Gugugaga", 1509));
//        friendAdapter.Add(new ExampleItem("Privet vsem", 7777));

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<ExampleItem> items = MainActivity.serverApi.getAllItems();
                getActivity().runOnUiThread(
                        () -> {
                            friendAdapter.Clear();
                            for (ExampleItem item : items) {
                                friendAdapter.Add(item);
                            }
                        }
                );
            }
        }).start();
        friendsRV.setAdapter(friendAdapter);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}