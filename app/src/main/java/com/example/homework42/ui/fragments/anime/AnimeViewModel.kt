package com.example.homework42.ui.fragments.anime

import com.example.homework42.base.BaseViewModel
import com.example.homework42.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val animeRepository: AnimeRepository) :
    BaseViewModel() {

    fun fetchAnime() = animeRepository.fetchAnime()
}