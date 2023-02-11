package com.example.homework42.data.models.anime

import com.google.gson.annotations.SerializedName

data class PosterImage(
    @SerializedName("original")
    val original: String = "",
)