package com.mvi.sample.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvi.sample.data.repo.CommonRepo
import com.mvi.sample.ui.FetchMovieShowIntent
import com.mvi.sample.ui.FetchMovieShowState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import java.lang.Exception

@ExperimentalCoroutinesApi
class FetchMovieShowsVM(
    private val repo: CommonRepo
) : ViewModel() {
    /**
     *  learn more about channels from
     *  https://www.raywenderlich.com/books/kotlin-coroutines-by-tutorials/v2.0/chapters/11-channels
     *
     */
    val movieShowIntent = Channel<FetchMovieShowIntent>(Channel.UNLIMITED)

    //define initial state as Idle
    private val _state = MutableStateFlow<FetchMovieShowState>(FetchMovieShowState.Idle)
    val state: StateFlow<FetchMovieShowState>
        get() = _state

    init {
        initIntent()
    }

    private fun initIntent() {
        viewModelScope.launch {
            movieShowIntent.consumeAsFlow().collect {
                when (it) {
                    is FetchMovieShowIntent.FetchShows -> fetchMovieShows()
                }
            }
        }
    }

    private fun fetchMovieShows() {
        viewModelScope.launch {
            _state.value = FetchMovieShowState.Loading
            _state.value = try {
                FetchMovieShowState.MovieShows(
                    repo.getFavoriteShows()
                )
            } catch (e: Exception) {
                FetchMovieShowState.Error(e.localizedMessage)
            }
        }
    }
}