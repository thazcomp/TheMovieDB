package br.com.themoviedb.repositories.main

import br.com.themoviedb.data.responses.ResultsResponse
import br.com.themoviedb.network.RetrofitInitializer
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainRepositoryImpl:MainRepository {

    override fun getNowPlaying(page: Int): Observable<ResultsResponse> {
        return RetrofitInitializer().createInterceptor().getNowPlaying(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getTopRated(page: Int): Observable<ResultsResponse> {
        return RetrofitInitializer().createInterceptor().getTopRated(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getPopular(page: Int): Observable<ResultsResponse> {
        return RetrofitInitializer().createInterceptor().getPopular(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getUpcoming(page: Int): Observable<ResultsResponse> {
        return RetrofitInitializer().createInterceptor().getUpcoming(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


}