package com.fernandoribeiro.mvvm.response.tvseries;

import com.fernandoribeiro.mvvm.models.tvseries.TvSeriesModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvSeriesSearchResponse {

    @SerializedName("total_results")
    @Expose
    private int total_count;

    @SerializedName("results")
    @Expose
    private List<TvSeriesModel> series;

    public int getTotal_count(){
        return total_count;
    }

    public List<TvSeriesModel> getSeries(){
        return series;
    }

    @Override
    public String toString() {
        return "TvSeriesSearchResponse{" +
                "total_count=" + total_count +
                ", series=" + series +
                '}';
    }
}
