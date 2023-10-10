package com.example.mylibraryapp.presentation.book

data class BookState (
    val isLoading: Boolean = false,
    val isbn: Long? = null,
    val title: String? = null,
    val error: String? = null
//    val pubDate: Int? = "",
//    val pages: Int? = null,
//    val language: Int,
//    val author: Int
)