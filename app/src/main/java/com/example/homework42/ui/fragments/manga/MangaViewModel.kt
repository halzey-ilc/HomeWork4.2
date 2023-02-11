package com.example.homework42.ui.fragments.manga

import com.example.homework42.base.BaseViewModel
import com.example.homework42.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(private val mangaRepository: MangaRepository) :
    BaseViewModel() {

    fun fetchManga() = mangaRepository.fetchManga()
}