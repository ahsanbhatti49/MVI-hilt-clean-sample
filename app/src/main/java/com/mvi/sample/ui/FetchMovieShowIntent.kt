package com.mvi.sample.ui

sealed class FetchMovieShowIntent{
    object FetchShows : FetchMovieShowIntent()
}
