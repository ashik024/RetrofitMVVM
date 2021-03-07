package com.example.retrofitmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofitmvvm.Model.MovieModel;
import com.example.retrofitmvvm.ViewModel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieListViewModel =new ViewModelProvider(this).get(MovieListViewModel.class);

        observeChange();

        searchApi("Batman",1);

//        getRetrofitResponse();
//        getRetrofitResponsePopular();
//        getRetrofitResponseById();
    }
    public void observeChange(){

        movieListViewModel.getMutableLiveData().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {

                if (movieModels!=null){
                    for (MovieModel movieModel : movieModels){
                        Log.i("tag1",movieModel.getOriginal_title());
                    }
                }

            }
        });

    }


    public void searchApi(String query, int pageNum) {
        movieListViewModel.searchApi(query,pageNum);
    }

//    private void getRetrofitResponse() {
//        ApiCalls apiCalls = (ApiCalls) Service. getApiCalls();
//
//
//        Call<MovieMultipleResponse> responseCall = apiCalls
//                .MOVIE_MULTIPLE_RESPONSE_CALL(
//                        Credential.Api_Key,
//                        "Titanic",
//                        1
//                );
//
//        responseCall.enqueue(new Callback<MovieMultipleResponse>() {
//            @Override
//            public void onResponse(Call<MovieMultipleResponse> call, Response<MovieMultipleResponse> response) {
//
//                if (response.code()==200){
//
//                    Log.d("tag1",response.body().toString());
//
//                    List<MovieModel> movies = new ArrayList<>(response.body().getMovies());
//
//                    for ( MovieModel movieModel: movies){
//                        Log.d("tag2", movieModel.getOriginal_title());
//
//                    }
//
//                }
//                else {
//                    Log.d("tag3","Error fetching data"+ response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MovieMultipleResponse> call, Throwable t) {
//
//            }
//        });
//
//
//
//
//    }
//
//
//
//    private void getRetrofitResponsePopular() {
//        ApiCalls apiCalls = (ApiCalls) Service. getApiCalls();
//
//        Call<MovieMultipleResponse> responseCall = apiCalls.popular(
//                Credential.Api_Key
//        );
//
//        responseCall.enqueue(new Callback<MovieMultipleResponse>() {
//            @Override
//            public void onResponse(Call<MovieMultipleResponse> call, Response<MovieMultipleResponse> response) {
//                if (response.code()==200) {
//
//
//                    Log.d("tag11", response.body().toString());
//                }List<MovieModel> movies = new ArrayList<>(response.body().getMovies());
//
//                for ( MovieModel movieModel: movies){
//                    Log.d("tag22", movieModel.getOriginal_title());
//                }
//
//                }
//
//            @Override
//            public void onFailure(Call<MovieMultipleResponse> call, Throwable t) {
//
//            }
//        });
//
//    }
//
//
//
//    private void getRetrofitResponseById() {
//
//        ApiCalls apiCalls = Service.getApiCalls();
//
//        Call<MovieModel> responseCall3 = apiCalls.getMovieId(
//                550,
//                Credential.Api_Key
//        );
//
//        responseCall3.enqueue(new Callback<MovieModel>() {
//            @Override
//            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
//                Log.d("tag111",response.body().getOriginal_title());
//            }
//
//            @Override
//            public void onFailure(Call<MovieModel> call, Throwable t) {
//
//            }
//        });
//
//    }
}