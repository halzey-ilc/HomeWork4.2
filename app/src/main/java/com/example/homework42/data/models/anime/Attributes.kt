package com.example.homework42.data.models.anime

import com.example.homework42.data.models.anime.MangaTitles
import com.example.homework42.data.models.anime.PosterImage
import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("posterImage")
    val posterImage: PosterImage,
    @SerializedName("titles")
    val titles: MangaTitles,
)