package com.example.recycleviewer.model

data class Movie(
    val id: Int,
    val image: String,
    val is_new: Int,
    val rating: String,
    val like_percent: Int,
    val vote_count: Int,
    val title: String,
    val language: String,
    val type: String
)