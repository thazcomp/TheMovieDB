package br.com.themoviedb.repositories.main

import br.com.themoviedb.data.responses.ResultsResponse
import io.reactivex.Observable


interface MainRepository {
    fun getNowPlaying(page:Int): Observable<ResultsResponse>
    fun getTopRated(page:Int): Observable<ResultsResponse>
    fun getPopular(page:Int): Observable<ResultsResponse>
    fun getUpcoming(page:Int): Observable<ResultsResponse>
}