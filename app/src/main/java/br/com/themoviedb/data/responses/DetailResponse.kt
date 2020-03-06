package br.com.themoviedb.data.responses

import com.google.gson.annotations.SerializedName

data class DetailResponse (
    @SerializedName("poster_path")
    val poster:String,

    @SerializedName("backdrop_path")
    val back:String,

    @SerializedName("id")
    val id:Int,

    @SerializedName("title")
    val title:String,

    @SerializedName("vote_average")
    val rating:Double,

    @SerializedName("overview")
    val detail:String,

    @SerializedName("release_date")
    val date:String,

    @SerializedName("genres")
    val genres:ArrayList<GenreResponse>
)