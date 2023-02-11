package com.example.homework42.ui.fragments.manga.detail

import com.example.homework42.base.BaseViewModel
import com.example.homework42.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel @Inject constructor(private val mangaRepository: MangaRepository) :
    BaseViewModel() {

    fun fetchMangaDetail(id: Int) = mangaRepository.fetchMangaDetail(id)
}