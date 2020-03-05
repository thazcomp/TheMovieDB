package br.com.themoviedb.data.responses

import com.google.gson.annotations.SerializedName

data class MoviesResponse (
    @SerializedName("poster_path")
    val poster:String,

    @SerializedName("id")
    val id:Int,

    @SerializedName("title")
    val title:String,

    @SerializedName("vote_average")
    val rating:Double
)