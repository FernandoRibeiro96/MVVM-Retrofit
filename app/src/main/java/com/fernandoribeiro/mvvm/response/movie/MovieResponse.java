package com.fernandoribeiro.mvvm.response.movie;

import com.fernandoribeiro.mvvm.models.movie.MovieModels;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResponse {

    //classe para um filme especifico

    @SerializedName("results")
    @Expose
    private MovieModels movie;

    public MovieModels getMovie(){
        return movie;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movie=" + movie +
                '}';
    }
}
