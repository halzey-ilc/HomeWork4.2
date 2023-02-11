package com.example.homework42.ui.fragments.anime.detail

import com.example.homework42.base.BaseViewModel
import com.example.homework42.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(private val animeRepository: AnimeRepository) :
    BaseViewModel() {

    fun fetchAnimeDetail(id: Int) = animeRepository.fetchAnimeDetail(id)
}