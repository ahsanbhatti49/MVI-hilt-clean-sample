package com.mvi.sample.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvi.sample.R
import com.mvi.sample.data.api.ApiHelperImplementor
import com.mvi.sample.data.api.RetrofitBuilder
import com.mvi.sample.data.dto.FavoriteShowsDto
import com.mvi.sample.utils.ktx.gone
import com.mvi.sample.utils.ktx.visible
import com.mvi.sample.vm.FetchMovieShowsVM
import com.mvi.sample.vm.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

    private var adapter = ShowsAdapter(arrayListOf())

    private val fetchMovieShowsViewModel: FetchMovieShowsVM by viewModels {
        ViewModelFactory(
            ApiHelperImplementor(
                RetrofitBuilder.apiService
            )
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
        observeViewModel()
        setupClicks()

    }

    /**
     * setupClicks on View
     */
    private fun setupClicks() {
        buttonFetchShows.setOnClickListener {
            lifecycleScope.launch {
                fetchMovieShowsViewModel.movieShowIntent.send(FetchMovieShowIntent.FetchShows)
            }
        }
    }

    /**
     * init View Model
     */
    private fun observeViewModel() {
        lifecycleScope.launch {
            fetchMovieShowsViewModel.state.collect {
                when (it) {
                    is FetchMovieShowState.Idle -> {
                        //TODO
                    }
                    is FetchMovieShowState.Loading -> {
                        buttonFetchShows.gone()
                        progressBar.visible()
                    }

                    is FetchMovieShowState.MovieShows -> {
                        progressBar.gone()
                        buttonFetchShows.gone()
                        displayMovieShows(it.movieShows)
                    }
                    is FetchMovieShowState.Error -> {
                        progressBar.gone()
                        buttonFetchShows.visible()
                        Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayMovieShows(movieShows: FavoriteShowsDto) {
        recyclerView.visible()
        movieShows.let { listOfUsers -> listOfUsers.let { adapter.addData(it.tv_shows) } }
        adapter.notifyDataSetChanged()
    }

    /**
     * setup recyclerView
     */
    private fun setupUI() {

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.run {
            addItemDecoration(
                DividerItemDecoration(
                    recyclerView.context,
                    (recyclerView.layoutManager as LinearLayoutManager).orientation
                )
            )
        }
        recyclerView.adapter = adapter
    }

}