package com.example.thi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestRe {
    @GET("api.json")
    Call<ListProducts> getJSON();
}
