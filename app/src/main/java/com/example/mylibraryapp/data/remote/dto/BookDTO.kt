package com.example.mylibraryapp.data.remote.dto

import com.example.mylibraryapp.domain.model.Book

data class BookDTO (
    val id: Int,
    val isbn: Long,
    val title: String,
    val pubDate: Int,
    val pages: Int,
    val author: Int,
    val language: Int
)

fun BookDTO.toBook() : Book {

    return Book(id = id, isbn = isbn, title = title, pubDate = pubDate, pages = pages, author = author, language = language)

}