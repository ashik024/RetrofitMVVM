package com.example.retrofitmvvm.Utils;



import com.example.retrofitmvvm.Model.MovieModel;
import com.example.retrofitmvvm.Response.MovieMultipleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiCalls {

//    https://api.themoviedb.org/3/search/movie?api_key=4ef5381695d3c33e4fc9e398efb773a8&query=Jack+Reacher

    @GET("3/search/movie?")
    Call<MovieMultipleResponse> MOVIE_MULTIPLE_RESPONSE_CALL(

            @Query("api_key")String key,
            @Query("query") String query,
            @Query("page") int page

    );

    //    https://api.themoviedb.org/3/movie/popular?api_key=4ef5381695d3c33e4fc9e398efb773a8

    @GET("3/movie/popular?")
    Call<MovieMultipleResponse> popular(

            @Query("api_key")String key


    );

//    https://api.themoviedb.org/3/movie/550?api_key=4ef5381695d3c33e4fc9e398efb773a8
    // api containing single object
    @GET("3/movie/{movie_id}?")
    Call<MovieModel> getMovieId(

            @Path("movie_id") int movie_id,
            @Query("api_key")String key


    );

}
