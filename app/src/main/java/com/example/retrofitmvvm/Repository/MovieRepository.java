package com.example.retrofitmvvm.Repository;

import androidx.lifecycle.LiveData;


import com.example.retrofitmvvm.Model.MovieModel;
import com.example.retrofitmvvm.Network.MovieApiClient;

import java.util.List;

public class MovieRepository {

        private static MovieRepository instance;

//liveData
//    private MutableLiveData<List<MovieModel>> mutableLiveData;

    private MovieApiClient movieApiClient;






    public static MovieRepository getInstance() {

        if (instance==null){
            instance = new MovieRepository();
        }

        return instance;
    }

    public MovieRepository() {

        movieApiClient = MovieApiClient.getInstance();
    }
    public LiveData<List<MovieModel>> getMovies(){


        return movieApiClient.getMovies();
    }

    public void searchApi(String query, int pageNum) {
        movieApiClient.searchApi(query,pageNum);
    }
}
