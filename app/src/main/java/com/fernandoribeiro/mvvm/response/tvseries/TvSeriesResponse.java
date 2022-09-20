package com.fernandoribeiro.mvvm.response.tvseries;

import com.fernandoribeiro.mvvm.models.tvseries.TvSeriesModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TvSeriesResponse {

    @SerializedName("results")
    @Expose
    private TvSeriesModel tvSeries;

    public TvSeriesModel getTvSeries(){
        return tvSeries;
    }

    @Override
    public String toString() {
        return "TvSeriesResponse{" +
                "tvSeries=" + tvSeries +
                '}';
    }
}
