package com.example.mylibraryapp.data.remote.dto

import com.example.mylibraryapp.domain.model.Author

data class AuthorDTO (
    val id: Int,
    val name: String
)

fun AuthorDTO.toAuthor() : Author {

    return Author(id = id, name = name)

}