package com.sng.assignmentvencent.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class NetworkInstance {
    private static Retrofit retrofit;
    private static final String Base_Url = "https://5e510330f2c0d300147c034c.mockapi.io/";

    public static Retrofit getInstance() {
        if (retrofit == null)
            retrofit = new Retrofit.Builder().baseUrl(Base_Url).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
