package com.example.retrofitmvvm;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutors {


    private static AppExecutors instance;

    public static AppExecutors getInstance() {

        if (instance==null){
            instance= new AppExecutors();
        }


        return instance;
    }

    private final ScheduledExecutorService scheduledExecutorServiceIO = Executors.newScheduledThreadPool(3);

    public ScheduledExecutorService networkIO(){
        return scheduledExecutorServiceIO;
    }

}
