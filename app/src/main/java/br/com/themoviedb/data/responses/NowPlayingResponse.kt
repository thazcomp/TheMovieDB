package br.com.themoviedb.data.responses

import com.google.gson.annotations.SerializedName

data class NowPlayingResponse (
    @SerializedName("results")
    val results: ArrayList<MoviesResponse>
)