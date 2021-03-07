package com.example.retrofitmvvm.Response;


import com.example.retrofitmvvm.Model.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieMultipleResponse {



    @SerializedName("total_results")
    @Expose
    private int totalCount;

    @SerializedName("results")
    @Expose

    private List<MovieModel> movies;



    public int getTotalCount(){
        return totalCount;
    }

    public List<MovieModel> getMovies(){
        return movies;
    }

    @Override
    public String toString() {
        return "MovieMultipleResponse{" +
                "totalCount=" + totalCount +
                ", movies=" + movies +
                '}';
    }
}
