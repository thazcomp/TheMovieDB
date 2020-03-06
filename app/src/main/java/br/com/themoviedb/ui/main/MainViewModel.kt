package br.com.themoviedb.ui.main

import androidx.lifecycle.ViewModel
import br.com.themoviedb.data.responses.ResultsResponse
import br.com.themoviedb.repositories.main.MainRepository
import br.com.themoviedb.repositories.main.MainRepositoryImpl
import io.reactivex.Observable

class MainViewModel: ViewModel() {

    private var mRepository: MainRepository = MainRepositoryImpl()

    fun getNowPlaying(page:Int):Observable<ResultsResponse>{
        return  mRepository.getNowPlaying(page)
    }

    fun getTopRated(page:Int):Observable<ResultsResponse>{
        return  mRepository.getTopRated(page)
    }

    fun getPopular(page:Int):Observable<ResultsResponse>{
        return  mRepository.getPopular(page)
    }

    fun getUpcoming(page:Int):Observable<ResultsResponse>{
        return  mRepository.getUpcoming(page)
    }

}