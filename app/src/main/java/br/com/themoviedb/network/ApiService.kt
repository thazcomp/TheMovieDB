package br.com.themoviedb.network
import br.com.themoviedb.data.responses.NowPlayingResponse
import io.reactivex.Observable
import retrofit2.http.*

interface ApiService {

    @GET("3/movie/now_playing?api_key=4fbdbdb7ab0a64a4ff94f65a19d7693a&language=pt-Br")
    fun getNowPlaying(@Query("page") page:Int): Observable<NowPlayingResponse>

    @GET("3/movie/popular?api_key=4fbdbdb7ab0a64a4ff94f65a19d7693a&language=pt-Br")
    fun getPopular(@Query("page") page:Int): Observable<NowPlayingResponse>

    @GET("3/movie/top_rated?api_key=4fbdbdb7ab0a64a4ff94f65a19d7693a&language=pt-Br")
    fun getTopRated(@Query("page") page:Int): Observable<NowPlayingResponse>

    @GET("3/movie/upcoming?api_key=4fbdbdb7ab0a64a4ff94f65a19d7693a&language=pt-Br")
    fun getUpcoming(@Query("page") page:Int): Observable<NowPlayingResponse>
}
