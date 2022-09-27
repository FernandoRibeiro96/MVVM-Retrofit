package com.fernandoribeiro.mvvm.repositories;

import androidx.lifecycle.LiveData;

import com.fernandoribeiro.mvvm.models.movie.MovieModels;
import com.fernandoribeiro.mvvm.requests.movie.MovieApiClient;

import java.util.List;

public class MovieRepository {

    private static MovieRepository instance;

    private MovieApiClient mMovieApiClient;

    private int mYear;

    private String mLanguage;

    private String mQueryNextPage;

    private int mPageNumberNextPage;

    public static MovieRepository getInstance(){
        if (instance == null){
            instance = new MovieRepository();
        }
        return instance;
    }

    private MovieRepository(){
        mMovieApiClient = MovieApiClient.getInstance();
    }

    public LiveData<List<MovieModels>> getMovies(){
        return mMovieApiClient.getMovies();
    }

    public LiveData<List<MovieModels>> getMoviesPop(){
        return mMovieApiClient.getMoviesPop();
    }

    public LiveData<List<MovieModels>> getMoviesPopPast(){
        return mMovieApiClient.getMoviesPopPast();
    }

    public void searchMovie(String query, int pageNumber){
        mQueryNextPage = query;
        mPageNumberNextPage = pageNumber;
        mMovieApiClient.searchMoviesApi(query, pageNumber);
    }

    public void searchMoviesPop(int pageNumber){
        mPageNumberNextPage = pageNumber;
        mMovieApiClient.searchMoviesPop(pageNumber);
    }

    public void  searchMoviePopPast(int year, int pageNumber, String language){
        mYear = year;
        mPageNumberNextPage = pageNumber;
        mLanguage = language;
        mMovieApiClient.searchMoviesPopPast(year, pageNumber, language);
    }

    public void searchNextPage(){
        searchMovie(mQueryNextPage, mPageNumberNextPage+1);
    }
}
