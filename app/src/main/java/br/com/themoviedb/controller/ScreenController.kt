package br.com.themoviedb.controller

import android.app.Activity
import br.com.themoviedb.goToActivity
import br.com.themoviedb.ui.main.activities.MainActivity
import br.com.themoviedb.ui.details.activities.DetailActivity

class ScreenController {
    companion object {
        fun nextStep(screen: Activity, movie:Int) {
            when (screen.javaClass) {
                MainActivity::class.java -> screen.goToActivity(DetailActivity::class.java, movie)
            }
        }
    }
}