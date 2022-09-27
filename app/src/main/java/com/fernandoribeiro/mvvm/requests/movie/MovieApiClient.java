package com.fernandoribeiro.mvvm.requests.movie;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fernandoribeiro.mvvm.extras.AppExecutors;
import com.fernandoribeiro.mvvm.models.movie.MovieModels;
import com.fernandoribeiro.mvvm.requests.ServiceRetrofit;
import com.fernandoribeiro.mvvm.response.movie.MovieSearchResponse;
import com.fernandoribeiro.mvvm.utils.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class MovieApiClient {

    //MVVM + LiveData
    private MutableLiveData<List<MovieModels>> mMovies;
    private MutableLiveData<List<MovieModels>> mMoviesPop;
    private MutableLiveData<List<MovieModels>> mMoviesPopPast;

    private MovieApiClient(){
        mMovies = new MutableLiveData<>();
        mMoviesPop = new MutableLiveData<>();
        mMoviesPopPast = new MutableLiveData<>();
    }

    private static MovieApiClient instance;

    public static MovieApiClient getInstance(){
        if (instance == null){
            instance = new MovieApiClient();
        }
        return instance;
    }

    public LiveData<List<MovieModels>> getMovies(){
        return mMovies;
    }

    public LiveData<List<MovieModels>> getMoviesPop(){
        return mMoviesPop;
    }

    public LiveData<List<MovieModels>> getMoviesPopPast(){
        return mMoviesPopPast;
    }

    private class RetrieveMoviesRunnable implements Runnable{

        private String query;
        private int pageNumber;
        boolean cancelRequest;

        public RetrieveMoviesRunnable(String query, int pageNumber, boolean cancelRequest) {
            this.query = query;
            this.pageNumber = pageNumber;
            this.cancelRequest = false;
        }
        public RetrieveMoviesRunnable(String query, int pageNumber) {
            this.query = query;
            this.pageNumber = pageNumber;
        }

        @Override
        public void run() {

            try{
                Response response = getMovies(query, pageNumber).execute();
                if (cancelRequest){
                    return;
                }
                if (response.code() == 200){
                    List<MovieModels> list = new ArrayList<>(((MovieSearchResponse)response.body()).getMovies());
                    if (pageNumber == 1){
                        mMovies.postValue(list);
                    }else {
                        List<MovieModels> currentMovies = mMovies.getValue();
                        currentMovies.addAll(list);
                        mMovies.postValue(currentMovies);

                    }
                }else{
                    String error = response.errorBody().string();
                    Log.v("Tag", "Error: "+error);
                    mMovies.postValue(null);
                }
            } catch (IOException e){
                e.printStackTrace();
                mMovies.postValue(null);
            }

            if (cancelRequest){
                return;
            }

        }

        private Call<MovieSearchResponse> getMovies(String query, int pageNumber){
            return ServiceRetrofit.getMovieApi().searchMovie(
                    Constants.API_KEY,
                    query,
                    pageNumber
            );
        }

        private void cancelRequest(){
            Log.v("Tag", "Canceling Search Request");
            cancelRequest = true;
        }

    }

    private  class RetrieveMovieRunnablePop implements Runnable{

        private int pageNumber;
        boolean cancelRequest;
        public RetrieveMovieRunnablePop(int pageNumber){
            this.pageNumber = pageNumber;
            cancelRequest = false;
        }
        @Override
        public void run() {

            try {
                Response response2 =getPop(pageNumber).execute();
                if (cancelRequest){
                    return;
                }
                if (response2.code() == 200){
                    List<MovieModels> list = new ArrayList<>(((MovieSearchResponse)response2.body()).getMovies());
                    if (pageNumber == 1){
                        mMoviesPop.postValue(list);
                    }else {
                        List<MovieModels> currentMovies = mMoviesPop.getValue();
                        currentMovies.addAll(list);
                        mMoviesPop.postValue(currentMovies);
                    }
                }else{
                    String error = response2.errorBody().string();
                    Log.v("Tag", "Error: "+error);
                    mMoviesPop.postValue(null);
                }

            }catch (IOException e){
                e.printStackTrace();
                mMoviesPop.postValue(null);
            }

            if (cancelRequest){
                return;
            }

        }
        private Call<MovieSearchResponse> getPop(int pageNumber){
            return  ServiceRetrofit.getMovieApi().getPopular(
                    Constants.API_KEY,
                    pageNumber
            );
        }
    }

    private class RetrieveMovieRunnablePopPast implements Runnable{

        private int mPageNumber;
        boolean mCancelRequest;
        private int mYear;
        private String mLanguage;

        public RetrieveMovieRunnablePopPast(int mPageNumber, boolean mCancelRequest, int mYear, String mLanguage) {
            this.mPageNumber = mPageNumber;
            this.mCancelRequest = false;
            this.mYear = mYear;
            this.mLanguage = mLanguage;
        }

        public RetrieveMovieRunnablePopPast(int year, int pageNumber, String language) {
            this.mPageNumber = pageNumber;
            this.mCancelRequest = false;
            this.mYear = year;
            this.mLanguage = language;
        }

        private Call<MovieSearchResponse> getMoviePopPast(int year, int pageNumber, String language){
            return ServiceRetrofit.getMovieApi().getMoviePopularPast(
                    year,
                    Constants.API_KEY,
                    pageNumber,
                    language
            );
        }

        private void cancelRequest(){
            Log.v("Tag", "Cancelling Search Request Movie Pop Past");
            mCancelRequest = true;
        }

        @Override
        public void run() {
            try{
                Response responsePopPast = getMoviePopPast(mYear, mPageNumber, mLanguage).execute();
                if (responsePopPast.code() == 200){
                    List<MovieModels> list = new ArrayList<>(((MovieSearchResponse)responsePopPast.body()).getMovies());

                    if (mPageNumber == 1){
                        mMoviesPopPast.postValue(list);
                    }else {
                        List<MovieModels> currentMovies = mMoviesPopPast.getValue();
                        currentMovies.addAll(list);
                        mMoviesPopPast.postValue(currentMovies);
                    }
                }else {
                    String error = responsePopPast.errorBody().string();
                    Log.v("Tag", "Error: "+error);
                    mMoviesPopPast.postValue(null);
                }

            }catch (IOException e){
                e.printStackTrace();
                mMoviesPopPast.postValue(null);
            }

            if (mCancelRequest){
                return;
            }
        }
    }

    private RetrieveMoviesRunnable mRetrieveMoviesRunnable;
    private RetrieveMovieRunnablePop mRetrieveMovieRunnablePop;
    private RetrieveMovieRunnablePopPast mRetrieveMovieRunnablePopPast;

    public void searchMoviesApi(String query, int pageNumber){
        if (mRetrieveMoviesRunnable != null){
            mRetrieveMoviesRunnable = null;
        }
        mRetrieveMoviesRunnable = new RetrieveMoviesRunnable(query, pageNumber);

        final Future myHandler = AppExecutors.getInstance().getmNetworkIO().submit(mRetrieveMoviesRunnable);

        AppExecutors.getInstance().getmNetworkIO().schedule(new Runnable() {
            @Override
            public void run() {
                myHandler.cancel(true);
            }
        }, 3000, TimeUnit.MILLISECONDS);
    }

    public void searchMoviesPop(int pageNumber){
        if (mRetrieveMovieRunnablePop != null){
            mRetrieveMovieRunnablePop = null;
        }
        mRetrieveMovieRunnablePop = new RetrieveMovieRunnablePop(pageNumber);
        final Future myHandler2 = AppExecutors.getInstance().getmNetworkIO().submit(mRetrieveMovieRunnablePop);

        AppExecutors.getInstance().getmNetworkIO().schedule(new Runnable() {
            @Override
            public void run() {
                myHandler2.cancel(true);
            }
        },1000, TimeUnit.MILLISECONDS);
    }

    public void searchMoviesPopPast(int year, int pageNumber, String language){
        if (mRetrieveMovieRunnablePopPast != null){
            mRetrieveMovieRunnablePopPast = null;
        }
        mRetrieveMovieRunnablePopPast = new RetrieveMovieRunnablePopPast(year,pageNumber,language);

        final Future myhandler3 = AppExecutors.getInstance().getmNetworkIO().submit(mRetrieveMovieRunnablePopPast);
        AppExecutors.getInstance().getmNetworkIO().schedule(new Runnable() {
            @Override
            public void run() {
                myhandler3.cancel(true);
            }
        }, 1000, TimeUnit.MILLISECONDS);
    }
}
