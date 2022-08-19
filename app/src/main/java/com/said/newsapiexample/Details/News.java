package com.said.newsapiexample.Details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {

    @SerializedName("articles")
    @Expose

    private List<NewsDetails> news;

    public List<NewsDetails> getNews() {
        return news;
    }

    public void setNews(List<NewsDetails> news) {
        this.news = news;
    }
}
