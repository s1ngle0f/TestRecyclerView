package com.example.testrecyclerview.api;

import android.util.Log;

import com.example.testrecyclerview.model.ExampleItem;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerApi {
    private static final String BASE_URL = "http://127.0.0.1:8080";
    OkHttpClient client;
    Retrofit retrofit;
    IServerApi serverApi;

    public ServerApi(){
        client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
//                                .addHeader("Authorization", "Bearer ")
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
//                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        serverApi = retrofit.create(IServerApi.class);
    }

    public List<ExampleItem> getAllItems(){
        List<ExampleItem> res = null;
        Call<List<ExampleItem>> callItems = serverApi.getAllItems();
        try {
            res = callItems.execute().body();
            System.out.println(res);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return res;
    }
}
