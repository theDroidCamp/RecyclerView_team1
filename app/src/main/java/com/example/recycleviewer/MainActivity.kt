package com.example.recycleviewer

import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val refresher = findViewById<SwipeRefreshLayout>(R.id.refresher)
    val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        refresher.setOnRefreshListener {
          //  fetchMovies()
        }

      //  fetchMovies()

    }

/*
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
       // recyclerView.layoutManager = LinearLayoutManager(this)
       // recyclerView.adapter = MoviesAdapter(movies)
    }
*/

}