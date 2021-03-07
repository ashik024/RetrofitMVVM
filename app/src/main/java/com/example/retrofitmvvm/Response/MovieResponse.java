package com.example.retrofitmvvm.Response;



import com.example.retrofitmvvm.Model.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//for single movie object
public class MovieResponse {
    @SerializedName("results")
    @Expose
     private MovieModel movieModel;

    public MovieModel getMovieModel(){
        return movieModel;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movieModel=" + movieModel +
                '}';
    }
}
