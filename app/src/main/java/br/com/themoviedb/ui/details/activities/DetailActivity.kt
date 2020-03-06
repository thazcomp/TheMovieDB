package br.com.themoviedb.ui.details.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.themoviedb.R
import br.com.themoviedb.data.responses.DetailResponse
import br.com.themoviedb.data.responses.GenreResponse
import br.com.themoviedb.ui.details.DetailViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.ArrayList

class DetailActivity : AppCompatActivity() {

    private val mViewModel: DetailViewModel by viewModel()
    private var disposable: Disposable? = null
    val MOVIE_BASE_URL = "https://image.tmdb.org/t/p/w185"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        getDetail(intent.getIntExtra("movie", 0))
    }

    private fun getDetail(movie:Int) {
        disposable = mViewModel.getDetail(movie).subscribeBy(
            onNext = {
                configureViews(it)
            },
            onError = {},
            onComplete = {}
        )
    }

    private fun configureViews(it: DetailResponse) {
        setCover(it.back)
        setName(it.title)
        setRating(it.rating)
        setOverview(it.detail)
        setGenre(it.genres)
        setDate(it.date)
    }

    private fun setDate(date: String) {
        val d = date.subSequence(0, 4)
        tv_release2.text = d.toString()
    }

    private fun setGenre(genres: ArrayList<GenreResponse>) {
        var aux:String = ""
        for(genre in genres){
            aux += genre.name + " "
        }
        tv_genre2.text = aux
    }

    private fun setOverview(detail: String) {
        tv_desc.text = detail
    }

    private fun setRating(rating: Double) {
        cr_bar.rating = rating.toFloat()
    }

    private fun setName(title: String) {
        tv_title.text = title
    }

    private fun setCover(poster: String) {
        val url = MOVIE_BASE_URL + poster
        Glide.with(this@DetailActivity)
            .load(url)
            .centerCrop()
            .into(iv_cover)
    }

    override fun onStop() {
        super.onStop()
        disposable?.let{
            it.dispose()
        }
    }
}
