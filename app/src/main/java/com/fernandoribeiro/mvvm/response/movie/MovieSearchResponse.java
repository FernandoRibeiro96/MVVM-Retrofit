package com.fernandoribeiro.mvvm.response.movie;

import com.fernandoribeiro.mvvm.models.movie.MovieModels;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieSearchResponse {

    //classe para varios filmes

    @SerializedName("total_results")
    @Expose()
    private int total_count;

    @SerializedName("results")
    @Expose
    private List<MovieModels> movies;

    public int getTotal_count(){
        return  total_count;
    }

    public List<MovieModels> getMovies(){
        return movies;
    }

    @Override
    public String toString() {
        return "MovieSearchResponse{" +
                "total_count=" + total_count +
                ", movies=" + movies +
                '}';
    }
}
