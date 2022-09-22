package com.fernandoribeiro.mvvm.extras;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutors {

    //padrão singleton para gerenciar o encadeamento de dados que tem origem na API

    public static AppExecutors instance;

    public static AppExecutors getInstance(){
        if (instance == null){
            instance = new AppExecutors();
        }
        return instance;
    }

    private final ScheduledExecutorService mNetworkIO = Executors.newScheduledThreadPool(3);

    public ScheduledExecutorService getmNetworkIO(){
        return mNetworkIO;
    }


}
