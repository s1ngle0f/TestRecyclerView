package com.example.testrecyclerview.api;

import com.example.testrecyclerview.model.ExampleItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IServerApi {
    @GET("/items")
    Call<List<ExampleItem>> getAllItems();
}
