package br.com.themoviedb

import android.app.Activity
import android.content.Intent

fun Activity.goToActivity(activityClass: Class<*>) {
    startActivity(Intent(this, activityClass))
}

fun Activity.goToActivity(activityClass: Class<*>, movie: Int) {
    val i:Intent = Intent(this, activityClass).putExtra("movie", movie)
    startActivity(i)
}