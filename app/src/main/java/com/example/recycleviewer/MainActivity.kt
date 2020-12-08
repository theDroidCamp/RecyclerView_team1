package com.example.recycleviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleviewer.adapter.MoviesAdapter
import com.example.recycleviewer.api.MoviesApi
import com.example.recycleviewer.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        refresher.setOnRefreshListener {
            fetchMovies()
        }

        fetchMovies()
    }

    private fun fetchMovies() {
        refresher.isRefreshing = true

        MoviesApi().getMovies().enqueue(object : Callback<List<Movie>> {
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                refresher.isRefreshing = false
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                refresher.isRefreshing = false
                val movies = response.body()
                movies?.let {
                    showMovies(it)
                }
            }
        })
    }

    private fun showMovies(movies: List<Movie>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MoviesAdapter(movies)
    }

}