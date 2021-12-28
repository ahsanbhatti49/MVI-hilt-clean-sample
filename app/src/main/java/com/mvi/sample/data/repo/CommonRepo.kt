package com.mvi.sample.data.repo

import com.mvi.sample.data.api.ApiHelper

class CommonRepo (private val apiHelper: ApiHelper) {
    suspend fun getFavoriteShows() = apiHelper.getFavoriteShow()
}