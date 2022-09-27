package com.fernandoribeiro.mvvm.viewmodels.movie;

import androidx.lifecycle.LiveData;

import com.fernandoribeiro.mvvm.models.movie.MovieModels;
import com.fernandoribeiro.mvvm.repositories.MovieRepository;

import java.util.List;

public class MovieListViewModel {

    private MovieRepository mMovieRepository;

    public  MovieListViewModel(){
        mMovieRepository = MovieRepository.getInstance();
    }

    public LiveData<List<MovieModels>> getMovies(){
        return mMovieRepository.getMovies();
    }

    public LiveData<List<MovieModels>> getMoviesPop(){
        return mMovieRepository.getMoviesPop();
    }

    public LiveData<List<MovieModels>> getMoviesPopPast(){
        return mMovieRepository.getMoviesPopPast();
    }

    public void searchMoviesApi(String query, int pageNumber){
        mMovieRepository.searchMovie(query, pageNumber);
    }

    public void searchMoviesApiPop(int pageNumber){
        mMovieRepository.searchMoviesPop(pageNumber);
    }

    public void searchMoviesApiPopPast(int year, int pageNumber, String language){
        mMovieRepository.searchMoviePopPast(year, pageNumber,language);
    }

    public void searchNextPage(){
        mMovieRepository.searchNextPage();
    }
}
