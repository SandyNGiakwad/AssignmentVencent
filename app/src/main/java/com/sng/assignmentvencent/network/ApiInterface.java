package com.sng.assignmentvencent.network;

import com.sng.assignmentvencent.model.Users;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("users")
    Call<ArrayList<Users>> getUsers();

}
