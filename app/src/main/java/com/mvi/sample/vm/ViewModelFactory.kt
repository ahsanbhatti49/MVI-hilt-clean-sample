package com.mvi.sample.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvi.sample.data.api.ApiHelper
import com.mvi.sample.data.repo.CommonRepo
import kotlinx.coroutines.ExperimentalCoroutinesApi

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    @ExperimentalCoroutinesApi
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FetchMovieShowsVM::class.java)) {
            return FetchMovieShowsVM(CommonRepo(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}