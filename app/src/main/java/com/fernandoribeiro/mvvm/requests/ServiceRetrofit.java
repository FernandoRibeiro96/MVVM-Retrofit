package com.fernandoribeiro.mvvm.requests;

import com.fernandoribeiro.mvvm.utils.Constants;
import com.fernandoribeiro.mvvm.utils.movie.MovieApi;
import com.fernandoribeiro.mvvm.utils.tvseries.TvSeriesAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceRetrofit {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static MovieApi movieApi = retrofit.create(MovieApi.class);

    public static MovieApi getMovieApi(){
        return movieApi;
    }

    public static TvSeriesAPI tvSeriesAPI = retrofit.create(TvSeriesAPI.class);

    public static TvSeriesAPI getTvSeriesAPI(){
        return tvSeriesAPI;
    }

}
