package com.fernandoribeiro.mvvm.adapters.movie;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fernandoribeiro.mvvm.R;

public class MoviePopularViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    //widgets
    ImageView mImageViewPop;
    RatingBar mRatingBarPop;

    OnMovieListener mOnMovieListener;

    public MoviePopularViewHolder(@NonNull View itemView, OnMovieListener onMovieListener) {
        super(itemView);

        this.mOnMovieListener = onMovieListener;

        mImageViewPop = itemView.findViewById(R.id.imageView_pop_movie);
        mRatingBarPop = itemView.findViewById(R.id.ratingBar_pop_movie);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        mOnMovieListener.onMovieClick(getLayoutPosition());

    }
}
