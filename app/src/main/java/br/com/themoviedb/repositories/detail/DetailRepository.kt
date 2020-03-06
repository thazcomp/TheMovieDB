package br.com.themoviedb.repositories.detail

import br.com.themoviedb.data.responses.DetailResponse
import io.reactivex.Observable


interface DetailRepository {
    fun getDetail(movie:Int): Observable<DetailResponse>
}