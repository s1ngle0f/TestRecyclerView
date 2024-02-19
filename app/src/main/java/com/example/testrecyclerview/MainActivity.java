package com.example.testrecyclerview;

import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testrecyclerview.adapter.ExampleAdapter;
import com.example.testrecyclerview.model.ExampleItem;

import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView friendsRV = findViewById(R.id.rv_example);
        friendsRV.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        ExampleAdapter friendAdapter = new ExampleAdapter();

        friendAdapter.Add(new ExampleItem("Gugugaga", 1509));
        friendAdapter.Add(new ExampleItem("Privet vsem", 7777));

        friendsRV.setAdapter(friendAdapter);
    }
}