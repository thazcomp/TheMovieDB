package br.com.themoviedb.repositories.detail

import br.com.themoviedb.data.responses.DetailResponse
import br.com.themoviedb.data.responses.ResultsResponse
import br.com.themoviedb.network.RetrofitInitializer
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailRepositoryImpl:DetailRepository {

    override fun getDetail(movie: Int): Observable<DetailResponse> {
        return RetrofitInitializer().createInterceptor().getDetail(movie)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}