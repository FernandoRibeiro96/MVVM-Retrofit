package com.fernandoribeiro.mvvm.models.tvseries;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TvSeriesModel implements Parcelable {

    protected TvSeriesModel(Parcel in){
        tvName = in.readString();
        tvNumber_of_episodes = in.readInt();
        tvNumber_of_seasons = in.readInt();
        tvOriginal_language = in.readString();
        tvOriginal_name = in.readString();
        tvOverview = in.readString();
        tvPoster_path = in.readString();
        tv_id = in.readInt();
        tvVote_average = in.readInt();
        tvBackdrop_path = in.readString();
    }

public static final Creator<TvSeriesModel> CREATOR = new Creator<TvSeriesModel>() {
    @Override
    public TvSeriesModel createFromParcel(Parcel parcel) {
        return new TvSeriesModel(parcel);
    }

    @Override
    public TvSeriesModel[] newArray(int i) {
        return new TvSeriesModel[i];
    }
};

    @SerializedName("name")
    private String tvName;
    @SerializedName("number_of_episodes")
    private int tvNumber_of_episodes;
    @SerializedName("number_of_seasons")
    private int tvNumber_of_seasons;
    @SerializedName("original_language")
    private String tvOriginal_language;
    @SerializedName("original_name")
    private String tvOriginal_name;
    @SerializedName("overview")
    private String tvOverview;
    @SerializedName("poster_path")
    private String tvPoster_path;
    @SerializedName("id")
    private int tv_id;
    @SerializedName("vote_average")
    private int tvVote_average;
    @SerializedName("backdrop_path")
    private String tvBackdrop_path;

    public TvSeriesModel(String tvName, int tvNumber_of_episodes, int tvNumber_of_seasons, String tvOriginal_language,
                         String tvOriginal_name, String tvOverview, String tvPoster_path, int tv_id, int tvVote_average, String tvBackdrop_path) {
        this.tvName = tvName;
        this.tvNumber_of_episodes = tvNumber_of_episodes;
        this.tvNumber_of_seasons = tvNumber_of_seasons;
        this.tvOriginal_language = tvOriginal_language;
        this.tvOriginal_name = tvOriginal_name;
        this.tvOverview = tvOverview;
        this.tvPoster_path = tvPoster_path;
        this.tv_id = tv_id;
        this.tvVote_average = tvVote_average;
        this.tvBackdrop_path = tvBackdrop_path;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public int getTvNumber_of_episodes() {
        return tvNumber_of_episodes;
    }

    public void setTvNumber_of_episodes(int tvNumber_of_episodes) {
        this.tvNumber_of_episodes = tvNumber_of_episodes;
    }

    public int getTvNumber_of_seasons() {
        return tvNumber_of_seasons;
    }

    public void setTvNumber_of_seasons(int tvNumber_of_seasons) {
        this.tvNumber_of_seasons = tvNumber_of_seasons;
    }

    public String getTvOriginal_language() {
        return tvOriginal_language;
    }

    public void setTvOriginal_language(String tvOriginal_language) {
        this.tvOriginal_language = tvOriginal_language;
    }

    public String getTvOriginal_name() {
        return tvOriginal_name;
    }

    public void setTvOriginal_name(String tvOriginal_name) {
        this.tvOriginal_name = tvOriginal_name;
    }

    public String getTvOverview() {
        return tvOverview;
    }

    public void setTvOverview(String tvOverview) {
        this.tvOverview = tvOverview;
    }

    public String getTvPoster_path() {
        return tvPoster_path;
    }

    public void setTvPoster_path(String tvPoster_path) {
        this.tvPoster_path = tvPoster_path;
    }

    public int getTv_id() {
        return tv_id;
    }

    public void setTv_id(int tv_id) {
        this.tv_id = tv_id;
    }

    public int getTvVote_average() {
        return tvVote_average;
    }

    public void setTvVote_average(int tvVote_average) {
        this.tvVote_average = tvVote_average;
    }

    public String getTvBackdrop_path() {
        return tvBackdrop_path;
    }

    public void setTvBackdrop_path(String tvBackdrop_path) {
        this.tvBackdrop_path = tvBackdrop_path;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(tvName);
        parcel.writeInt(tvNumber_of_episodes);
        parcel.writeInt(tvNumber_of_seasons);
        parcel.writeString(tvOriginal_language);
        parcel.writeString(tvOriginal_name);
        parcel.writeString(tvOverview);
        parcel.writeString(tvPoster_path);
        parcel.writeInt(tv_id);
        parcel.writeInt(tvVote_average);
        parcel.writeString(tvBackdrop_path);

    }

    @Override
    public String toString() {
        return "TvSeriesModel{" +
                "tvName='" + tvName + '\'' +
                ", tvNumber_of_episodes=" + tvNumber_of_episodes +
                ", tvNumber_of_seasons=" + tvNumber_of_seasons +
                ", tvOriginal_language='" + tvOriginal_language + '\'' +
                ", tvOriginal_name='" + tvOriginal_name + '\'' +
                ", tvOverview='" + tvOverview + '\'' +
                ", tvPoster_path='" + tvPoster_path + '\'' +
                ", tv_id=" + tv_id +
                ", tvVote_average=" + tvVote_average +
                ", tvBackdrop_path='" + tvBackdrop_path + '\'' +
                '}';
    }
}
