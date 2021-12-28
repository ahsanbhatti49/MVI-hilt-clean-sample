package com.mvi.sample.data.dto


data class FavoriteShowsDto(
    val page: Int,
    val pages: Int,
    val total: String,
    val tv_shows: List<TvShow>
)

data class TvShow(
    val country: String,
    val end_date: Any,
    val id: Int,
    val image_thumbnail_path: String,
    val name: String,
    val network: String,
    val permalink: String,
    val start_date: String,
    val status: String
)