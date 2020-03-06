package br.com.themoviedb.data.responses

import com.google.gson.annotations.SerializedName

data class GenreResponse (
    @SerializedName("name")
    val name:String,

    @SerializedName("id")
    val id:Int
)