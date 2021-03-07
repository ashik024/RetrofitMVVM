package com.example.retrofitmvvm.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.retrofitmvvm.Model.MovieModel;
import com.example.retrofitmvvm.Repository.MovieRepository;

import java.util.List;

public class MovieListViewModel extends ViewModel {

//liveData
//    private MutableLiveData <List<MovieModel>> mutableLiveData = new MutableLiveData<>();


    private MovieRepository movieRepository;

    public MovieListViewModel() {

        movieRepository= MovieRepository.getInstance();

    }

    public MutableLiveData<List<MovieModel>> getMutableLiveData() {

        return (MutableLiveData<List<MovieModel>>) movieRepository.getMovies();
    }

    public void searchApi(String query, int pageNum) {
        movieRepository.searchApi(query,pageNum);
    }
}

