package com.example.mylibraryapp.presentation.book.listscreen

import com.example.mylibraryapp.domain.model.Book

data class BookListState(
    val isLoading: Boolean = false,
    val list: List<Book> = emptyList(),
    val error: String? = null
)