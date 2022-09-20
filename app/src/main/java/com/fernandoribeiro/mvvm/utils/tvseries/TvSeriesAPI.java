package com.fernandoribeiro.mvvm.utils.tvseries;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TvSeriesAPI {

    @GET("/3/search/tv")
    Call<TvSeriesSearchResponse> searchTvSeries(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") int page
    );

    @GET("/3/tv/popular")
    Call<TvSeriesSearchResponse> getPopular(
            @Query("api_key") String key,
            @Query("page") int page
    );
    @GET("/3/tv/{tvSeries_id}?")
    Call<TvSerieModel> getTvSeries(
            @Query("api_key") String key,
            @Path("tvSeries_id") int tvSeries_id
    );
}
