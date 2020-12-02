package com.example.recycleviewer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycleviewer.Movie
import com.example.recycleviewer.R

/**
 *  Adapter for the [RecyclerView] in [MainActicity]. displays Movie data.
 */
class MoviesAdapter(val movies : List<Movie>) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    // Provide a reference to the views for each data item
    // Each data item fetched is just a Movie type.
    class MovieViewHolder( val view: View) : RecyclerView.ViewHolder(view)

    /**
     *  Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_movie, parent, false)
        )
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.view.textViewTitle.text = movie.title
        holder.view.textViewLanguage.text = movie.language
        holder.view.textViewType.text = movie.type
        holder.view.textViewRating.text = movie.rating
        holder.view.textViewLikePercent.text = movie.likePercent.toString() + "%"
        holder.view.textViewVotesCount.text = movie.VoteCount.toString() + "votes"
        holder.view.textViewIsNew.visibility = if (movie.isNew == 1) View.VISIBLE else View.INVISIBLE

        Glide.with(holder.view.context)
            .load(movie.image)
            .into(holder.view.imageView)
    }

   /**
    * Return the size of your dataset (invoked by the layout manager)
    */
    override fun getItemCount() = movies.size
}