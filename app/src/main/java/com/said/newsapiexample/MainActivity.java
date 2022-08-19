package com.said.newsapiexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.said.newsapiexample.Adapter.RecycleViewAdapter;
import com.said.newsapiexample.Api.NewsApi;
import com.said.newsapiexample.Details.News;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {





    public static String BASE_URL="https://newsapi.org/";
    RecyclerView recyclerView;
    Retrofit retrofit;
    RecycleViewAdapter recycleViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=findViewById(R.id.recyclerView);

        Gson gson= new GsonBuilder().setLenient().create();

        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        loadData();
    }


public void loadData(){


    NewsApi newsApi=retrofit.create(NewsApi.class);

    Call<News> call= newsApi.getData();
    call.enqueue(new Callback<News>() {
        @Override
        public void onResponse(Call<News> call, Response<News> response) {
            News responseList = response.body();

            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            recycleViewAdapter= new RecycleViewAdapter(responseList);
            recyclerView.setAdapter(recycleViewAdapter);
        }

        @Override
        public void onFailure(Call<News> call, Throwable t) {
            t.printStackTrace();
        }
    });





}
}