package br.com.themoviedb.ui.details

import androidx.lifecycle.ViewModel
import br.com.themoviedb.data.responses.DetailResponse
import br.com.themoviedb.data.responses.ResultsResponse
import br.com.themoviedb.repositories.detail.DetailRepository
import br.com.themoviedb.repositories.detail.DetailRepositoryImpl
import br.com.themoviedb.repositories.main.MainRepository
import br.com.themoviedb.repositories.main.MainRepositoryImpl
import io.reactivex.Observable

class DetailViewModel: ViewModel() {

    private var mRepository: DetailRepository = DetailRepositoryImpl()

    fun getDetail(movie:Int):Observable<DetailResponse>{
        return  mRepository.getDetail(movie)
    }

}