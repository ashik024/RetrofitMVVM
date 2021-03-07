package com.example.retrofitmvvm.Network;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.example.retrofitmvvm.AppExecutors;
import com.example.retrofitmvvm.Model.MovieModel;
import com.example.retrofitmvvm.Response.MovieMultipleResponse;
import com.example.retrofitmvvm.Utils.Credential;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class MovieApiClient {

    private static MovieApiClient instance;
    //liveData
    private MutableLiveData<List<MovieModel>> mutableLiveData;

    private RetrievingDataFromApi retrievingDataFromApi;


    public static MovieApiClient getInstance() {

        if (instance == null) {
            instance = new MovieApiClient();
        }
        return instance;
    }

    public MovieApiClient() {

        mutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<MovieModel>> getMovies() {

        return mutableLiveData;
    }


    //calling api
    public void searchApi(String query, int pageNum) {


//        final Future myHandler = (Future) AppExecutors.getInstance().networkIO().submit(new Runnable() {
//            @Override
//            public void run() {
//
//                //getting data from api calls
//
//
//
//            }
//        });
        if (retrievingDataFromApi != null) {
            retrievingDataFromApi = null;
        }

        retrievingDataFromApi= new RetrievingDataFromApi(query,pageNum);

        final Future myHandler = AppExecutors.getInstance().networkIO().submit(retrievingDataFromApi);
       AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {

                //canceling api calls
                myHandler.cancel(true);
            }
        }, 5000, TimeUnit.MILLISECONDS);
    }

    private class RetrievingDataFromApi implements Runnable {

        private String query;
        private int pageNum;
        private boolean cancelReq;

        public RetrievingDataFromApi(String query, int pageNum) {
            this.query = query;
            this.pageNum = pageNum;
            cancelReq = false;
        }

        @Override
        public void run() {

            //getting response from server

            try {
                Response response = getMovies(query, pageNum).execute();


                if (cancelReq) {
                    return;
                }


                if (response.code() == 200) {

                    List<MovieModel> list = new ArrayList<>(((MovieMultipleResponse) response.body()).getMovies());
                    if (pageNum == 1) {
                        //sending data to live data
                        mutableLiveData.postValue(list);


                    } else {
                        List<MovieModel> currentMovies = mutableLiveData.getValue();
                        currentMovies.addAll(list);
                        mutableLiveData.postValue(currentMovies);
                    }


                }
                else {
                    Log.v("Tag : ","Error : "+response.errorBody().string());
                    mutableLiveData.postValue(null);
                }

            } catch (IOException e) {
                e.printStackTrace();
                mutableLiveData.postValue(null);
            }


        }

        private Call<MovieMultipleResponse> getMovies(String query, int pageNum) {

           return Service.getApiCalls().MOVIE_MULTIPLE_RESPONSE_CALL(
                    Credential.Api_Key,
                    query,
                    pageNum
            );

        }

        private void cancelReq() {

            Log.i("tag", "Cancelled");
            cancelReq = true;
        }


    }


}
