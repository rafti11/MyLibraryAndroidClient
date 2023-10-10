package com.example.mylibraryapp.domain.model

data class Book (
    val id: Int,
    val isbn: Long,
    val title: String,
    val pubDate: Int,
    val pages: Int,
    val language: Int,
    val author: Int
)