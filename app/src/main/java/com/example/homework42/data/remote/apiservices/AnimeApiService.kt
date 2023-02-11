package com.example.homework42.data.remote.apiservices

import com.example.homework42.data.models.anime.DataItem
import com.example.homework42.data.models.anime.Response
import com.example.homework42.data.models.anime.detail.AnimeDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(): Response<DataItem>

    @GET("anime/{id}")
    suspend fun fetchAnimeDetail(
        @Path("id") id: Int
    ): AnimeDetail

}