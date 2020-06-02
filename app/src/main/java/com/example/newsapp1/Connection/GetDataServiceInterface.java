package com.example.newsapp1.Connection;

import com.example.newsapp1.viewModel.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataServiceInterface {

    @GET("top-headlines")
    Call<Results> getResult(@Query("country") String country, @Query("category") String category, @Query("apiKey") String apiKey);


}
