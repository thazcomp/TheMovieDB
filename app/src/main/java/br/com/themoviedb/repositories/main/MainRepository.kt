package br.com.themoviedb.repositories.main

import br.com.themoviedb.data.responses.NowPlayingResponse
import io.reactivex.Observable


interface MainRepository {
    fun getNowPlaying(page:Int): Observable<NowPlayingResponse>
    fun getTopRated(page:Int): Observable<NowPlayingResponse>
    fun getPopular(page:Int): Observable<NowPlayingResponse>
    fun getUpcoming(page:Int): Observable<NowPlayingResponse>
}