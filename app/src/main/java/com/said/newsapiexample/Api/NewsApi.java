package com.said.newsapiexample.Api;

import com.said.newsapiexample.Details.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApi {


    @GET("v2/top-headlines?country=tr&apiKey=API_KEY")
    Call<News> getData();
}
