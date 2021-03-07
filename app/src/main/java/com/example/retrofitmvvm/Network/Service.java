package com.example.retrofitmvvm.Network;



import com.example.retrofitmvvm.Utils.ApiCalls;
import com.example.retrofitmvvm.Utils.Credential;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

 public static Retrofit.Builder builder = new Retrofit.Builder()
         .baseUrl(Credential.base_url)
         .addConverterFactory(GsonConverterFactory.create());

    public static Retrofit retrofit = builder.build();

    public static ApiCalls apiCalls= retrofit.create(ApiCalls.class);

    public static ApiCalls getApiCalls(){

        return apiCalls;
    }

}
