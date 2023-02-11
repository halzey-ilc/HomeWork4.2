package com.example.homework42.data.repositories

import com.example.homework42.data.remote.apiservices.AnimeApiService
import com.example.homework42.base.BaseRepository
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiService) : BaseRepository() {

    fun fetchAnime() = doRequest {
        service.fetchAnime()
    }

    fun fetchAnimeDetail(id: Int) = doRequest {
        service.fetchAnimeDetail(id = id)
    }
}