package com.example.homework42.data.repositories

import com.example.homework42.data.remote.apiservices.MangaApiService
import com.example.homework42.base.BaseRepository
import javax.inject.Inject

class MangaRepository @Inject constructor(private val service: MangaApiService) : BaseRepository() {

    fun fetchManga() = doRequest {
        service.fetchManga()
    }
    fun fetchMangaDetail(id: Int) = doRequest {
        service.fetchMangaDetail(id = id)
    }
}