package com.example.arnau.minim2_github;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {

    @GET ("/users/{user}")
    Call<User> getUser(@Path("user") String user);

    @GET("/users/{user}/followers")
    Call<List<User>> getFollowers(@Path("user") String user);
}
