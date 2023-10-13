package com.example.mylibraryapp.presentation.author.listscreen

import com.example.mylibraryapp.domain.model.Author

data class AuthorListState(
    val isLoading: Boolean = false,
    val list: List<Author> = emptyList(),
    val error: String? = null
)