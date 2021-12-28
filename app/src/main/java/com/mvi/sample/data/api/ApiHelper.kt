package com.mvi.sample.data.api

import com.mvi.sample.data.dto.FavoriteShowsDto

interface ApiHelper {
    suspend fun getFavoriteShow(): FavoriteShowsDto
}