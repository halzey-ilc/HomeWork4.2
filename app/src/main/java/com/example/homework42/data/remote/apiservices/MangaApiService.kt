package com.example.homework42.data.remote.apiservices

import com.example.homework42.data.models.anime.Response
import com.example.homework42.data.models.anime.DataItem
import com.example.homework42.data.models.anime.detail.MangaDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface MangaApiService {

    @GET("manga")
    suspend fun fetchManga(): Response<DataItem>

    @GET("manga/{id}")
    suspend fun fetchMangaDetail(
        @Path("id") id: Int
    ): MangaDetail
}