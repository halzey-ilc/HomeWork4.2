package com.example.homework42.data.models.anime.detail

import com.example.homework42.data.models.anime.DataItem
import com.google.gson.annotations.SerializedName

data class MangaDetail(
    @SerializedName("data")
    val data: DataItem
)
