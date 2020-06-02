package com.example.newsapp1.viewModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("totalResults")
    @Expose
    private String totalResults;
    @SerializedName("articles")
    @Expose
    private Articles[] articles;
    @SerializedName("status")
    @Expose
    private String status;

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public Articles[] getArticles() {
        return articles;
    }

    public void setArticles(Articles[] articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Results [totalResults = " + totalResults + ", articles = " + articles + ", status = " + status + "]";
    }
}
