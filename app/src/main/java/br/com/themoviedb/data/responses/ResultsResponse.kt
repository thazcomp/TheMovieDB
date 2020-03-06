package br.com.themoviedb.data.responses

import com.google.gson.annotations.SerializedName

data class ResultsResponse (
    @SerializedName("results")
    val results: ArrayList<MoviesResponse>
)