package com.soal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {
    String baseUrl = "https://dog.ceo/api/breed/boxer/";

    @GET("images")
    Call<ResponseGambar> getGambar();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    ApiService service = retrofit.create(ApiService.class);
}
