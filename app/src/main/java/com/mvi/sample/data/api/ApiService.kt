package com.mvi.sample.data.api

import com.mvi.sample.data.dto.FavoriteShowsDto
import retrofit2.http.GET

interface ApiService {
    //add param and increase the page count for pagination
    @GET("/api/most-popular?page=1")
    suspend fun getFavouriteShows(): FavoriteShowsDto
}