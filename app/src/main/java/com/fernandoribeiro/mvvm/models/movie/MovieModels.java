package com.fernandoribeiro.mvvm.models.movie;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MovieModels implements Parcelable {

    //recebe os dados que foram transitados
    protected MovieModels(Parcel in){
        mTitle = in.readString();
        mPoster_path = in.readString();
        mRelease_date = in.readString();
        mMovie_id = in.readInt();
        mVote_average = in.readFloat();
        mMovie_overview = in.readString();
        mOriginal_title = in.readString();
        mRuntime = in.readInt();
        mOriginal_language = in.readString();
        mBackdrop_path = in.readString();
        mIsAdult = in.readByte() != 0; //mIsAdult == true if byte != 0
    }

public static final Creator<MovieModels> CREATOR = new Creator<MovieModels>() {
    @Override
    public MovieModels createFromParcel(Parcel source) {
        return new MovieModels(source); //in = source
    }

    @Override
    public MovieModels[] newArray(int i) {
        return new MovieModels[i];
    }
};

    @SerializedName("title")
    private String mTitle;
    @SerializedName("poster_path")
    private String mPoster_path;
    @SerializedName("release_date")
    private String mRelease_date;
    @SerializedName("movie_id")
    private int mMovie_id;
    @SerializedName("vote_average")
    private float mVote_average;
    @SerializedName("movie_overview")
    private String mMovie_overview;
    @SerializedName("original_title")
    private String mOriginal_title;
    @SerializedName("runtime")
    private int mRuntime;
    @SerializedName("original_language")
    private String mOriginal_language;
    @SerializedName("backdrop_path")
    private String mBackdrop_path;
    @SerializedName("adult")
    private boolean mIsAdult;
    
    public MovieModels(String title,String poster_path,String release_date, int movie_id, float vote_average,
                       String movie_overview, String original_title, int runtime, String original_language, String backdrop_path, boolean isAdult ){

        this.mTitle = title;
        this.mPoster_path = poster_path;
        this.mRelease_date = release_date;
        this.mMovie_id = movie_id;
        this.mVote_average = vote_average;
        this.mMovie_overview = movie_overview;
        this.mOriginal_title = original_title;
        this.mRuntime = runtime;
        this.mOriginal_language = original_language;
        this.mBackdrop_path = backdrop_path;
        this.mIsAdult = isAdult;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmPoster_path() {
        return mPoster_path;
    }

    public void setmPoster_path(String mPoster_path) {
        this.mPoster_path = mPoster_path;
    }

    public String getmRelease_date() {
        return mRelease_date;
    }

    public void setmRelease_date(String mRelease_date) {
        this.mRelease_date = mRelease_date;
    }

    public int getmMovie_id() {
        return mMovie_id;
    }

    public void setmMovie_id(int mMovie_id) {
        this.mMovie_id = mMovie_id;
    }

    public float getmVote_average() {
        return mVote_average;
    }

    public void setmVote_average(float mVote_average) {
        this.mVote_average = mVote_average;
    }

    public String getmMovie_overview() {
        return mMovie_overview;
    }

    public void setmMovie_overview(String mMovie_overview) {
        this.mMovie_overview = mMovie_overview;
    }

    public String getmOriginal_title() {
        return mOriginal_title;
    }

    public void setmOriginal_title(String mOriginal_title) {
        this.mOriginal_title = mOriginal_title;
    }

    public int getmRuntime() {
        return mRuntime;
    }

    public void setmRuntime(int mRuntime) {
        this.mRuntime = mRuntime;
    }

    public String getmOriginal_language() {
        return mOriginal_language;
    }

    public void setmOriginal_language(String mOriginal_language) {
        this.mOriginal_language = mOriginal_language;
    }

    public String getmBackdrop_path() {
        return mBackdrop_path;
    }

    public void setmBackdrop_path(String mBackdrop_path) {
        this.mBackdrop_path = mBackdrop_path;
    }

    public boolean ismIsAdult() {
        return mIsAdult;
    }

    public void setmIsAdult(boolean mIsAdult) {
        this.mIsAdult = mIsAdult;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(mTitle);
        parcel.writeString(mPoster_path);
        parcel.writeString(mRelease_date);
        parcel.writeInt(mMovie_id);
        parcel.writeFloat(mVote_average);
        parcel.writeString(mMovie_overview);
        parcel.writeString(mOriginal_title);
        parcel.writeInt(mRuntime);
        parcel.writeString(mOriginal_language);
        parcel.writeString(mBackdrop_path);
        parcel.writeByte((byte) (mIsAdult ? 1: 0)); //if mIsAdult == true, byte == 1



    }

    @Override
    public String toString() {
        return "MovieModels{" +
                "mTitle='" + mTitle + '\'' +
                ", mPoster_path='" + mPoster_path + '\'' +
                ", mRelease_date='" + mRelease_date + '\'' +
                ", mMovie_id=" + mMovie_id +
                ", mVote_average=" + mVote_average +
                ", mMovie_overview='" + mMovie_overview + '\'' +
                ", mOriginal_title='" + mOriginal_title + '\'' +
                ", mRuntime=" + mRuntime +
                ", mOriginal_language='" + mOriginal_language + '\'' +
                ", mBackdrop_path='" + mBackdrop_path + '\'' +
                ", mIsAdult=" + mIsAdult +
                '}';
    }
}
