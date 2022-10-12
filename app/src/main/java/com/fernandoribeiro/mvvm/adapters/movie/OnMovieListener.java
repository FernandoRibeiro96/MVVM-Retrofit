package com.fernandoribeiro.mvvm.adapters.movie;

public interface OnMovieListener {

    public void onMovieClick(int position);

    void onCategoryClick(String category);
}
