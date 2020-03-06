package br.com.themoviedb.ui.main.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.themoviedb.R
import br.com.themoviedb.data.responses.MoviesResponse
import br.com.themoviedb.ui.main.MainViewModel
import br.com.themoviedb.ui.main.adapters.MoviesAdapter
import br.com.themoviedb.util.PaginationScrollListener
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mViewModel: MainViewModel by viewModel()
    private var disposable: Disposable? = null

    private val mNowPlayingAdapter: MoviesAdapter by lazy {
        MoviesAdapter(
            this,
            arrayListOf()
        )
    }

    private val mPopularAdapter: MoviesAdapter by lazy {
        MoviesAdapter(
            this,
            arrayListOf()
        )
    }

    private val mTopRatedAdapter: MoviesAdapter by lazy {
        MoviesAdapter(
            this,
            arrayListOf()
        )
    }

    private val mUpcomingAdapter: MoviesAdapter by lazy {
        MoviesAdapter(
            this,
            arrayListOf()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showLoading()
        initRecyclers()
        getMovies()
    }

    private fun showLoading(){
        cl_loading.visibility = View.VISIBLE
    }

    private fun hideLoading(){
        cl_loading.visibility = View.GONE
    }

    private fun getMovies() {
        getNowPlaying()
        getPopular()
        getTopRated()
        getUpcoming()
    }

    private fun getUpcoming() {
        disposable = mViewModel.getUpcoming(1).subscribeBy(
            onNext = {
                setUpcomingItems(it.results)
            },
            onError = {
                hideLoading()
            },
            onComplete = {
                hideLoading()
            }
        )
    }

    private fun getTopRated() {
        disposable = mViewModel.getTopRated(1).subscribeBy(
            onNext = {
                setTopRatedItems(it.results)
            },
            onError = {
                hideLoading()
            },
            onComplete = {
                hideLoading()
            }
        )
    }

    private fun getPopular() {
        disposable = mViewModel.getPopular(1).subscribeBy(
            onNext = {
                setPopularItems(it.results)
            },
            onError = {
                hideLoading()
            },
            onComplete = {
                hideLoading()
            }
        )
    }

    private fun getNowPlaying() {
        disposable = mViewModel.getNowPlaying(1).subscribeBy(
            onNext = {
                setNowPlayingItems(it.results)
            },
            onError = {
                hideLoading()
            },
            onComplete = {
                hideLoading()
            }
        )
    }

    private fun setNowPlayingItems(items:ArrayList<MoviesResponse>) {
        mNowPlayingAdapter.setList(items)
    }

    private fun setPopularItems(items:ArrayList<MoviesResponse>) {
        mPopularAdapter.setList(items)
    }

    private fun setTopRatedItems(items:ArrayList<MoviesResponse>) {
        mTopRatedAdapter.setList(items)
    }

    private fun setUpcomingItems(items:ArrayList<MoviesResponse>) {
        mUpcomingAdapter.setList(items)
    }

    private fun initRecyclers() {
        rv_cat1.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rv_cat1.adapter = mNowPlayingAdapter

        rv_cat2.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rv_cat2.adapter = mPopularAdapter

        rv_cat3.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rv_cat3.adapter = mTopRatedAdapter

        rv_cat4.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rv_cat4.adapter = mUpcomingAdapter

    }

    override fun onStop() {
        super.onStop()
        disposable?.let{
            it.dispose()
        }
    }
}
