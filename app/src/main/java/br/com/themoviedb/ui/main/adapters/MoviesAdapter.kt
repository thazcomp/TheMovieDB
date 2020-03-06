package br.com.themoviedb.ui.main.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.themoviedb.R
import br.com.themoviedb.controller.ScreenController
import br.com.themoviedb.data.responses.MoviesResponse
import br.com.themoviedb.goToActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import hyogeun.github.com.colorratingbarlib.ColorRatingBar


class MoviesAdapter (val context:Context,
                     val list:ArrayList<MoviesResponse>):RecyclerView.Adapter<MoviesAdapter.ViewHolder>(){

    val MOVIE_BASE_URL = "https://image.tmdb.org/t/p/w185"

    override fun onCreateViewHolder(group: ViewGroup, position: Int): ViewHolder {
        val v = LayoutInflater.from(group.context).inflate(R.layout.movie_item, group, false)
        return ViewHolder(v)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cover = itemView.findViewById<ImageView>(R.id.iv_cover)
        val title = itemView.findViewById<TextView>(R.id.tv_title)
        val rating = itemView.findViewById<ColorRatingBar>(R.id.cr_bar)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemId(position: Int): Long {
        return list[position].id.toLong()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        loadImage(holder, position)
        setTitle(holder, position)
        setRating(holder, position)
        setOnClick(holder, position)
    }

    private fun setOnClick(holder: ViewHolder, position: Int) {
        holder.cover.setOnClickListener{
            ScreenController.nextStep(context as Activity, list[position].id)
        }
    }

    private fun setRating(holder: ViewHolder, position: Int) {
        holder.rating.rating = (list[position].rating/2).toFloat()
    }

    private fun setTitle(holder: ViewHolder, position: Int) {
        holder.title.text = list[position].title
    }

    private fun loadImage(holder: ViewHolder, position: Int) {
        val url = MOVIE_BASE_URL + list[position].poster
        Glide.with(context)
            .load(url)
            .transform(RoundedCorners(16))
            .into(holder.cover)
    }

    fun setList(l:ArrayList<MoviesResponse>){
        list.clear()
        list.addAll(l)
        notifyDataSetChanged()
    }

    fun addList(l:ArrayList<MoviesResponse>){
        list.addAll(l)
        notifyDataSetChanged()
    }
}