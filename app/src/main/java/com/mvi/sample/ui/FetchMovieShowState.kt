package com.mvi.sample.ui

import com.mvi.sample.data.dto.FavoriteShowsDto

sealed class FetchMovieShowState {
    object Idle : FetchMovieShowState()//idle state
    object Loading : FetchMovieShowState()//when action is in progress show loading to user
    data class MovieShows(val movieShows: FavoriteShowsDto) : FetchMovieShowState()//action completed update ui
    data class Error(val error: String?) : FetchMovieShowState()//action failed,show error
}
