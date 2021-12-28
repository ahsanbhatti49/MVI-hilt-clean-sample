package com.mvi.sample.data.api

import com.mvi.sample.data.dto.FavoriteShowsDto

class ApiHelperImplementor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getFavoriteShow(): FavoriteShowsDto {
        return apiService.getFavouriteShows()
    }
}