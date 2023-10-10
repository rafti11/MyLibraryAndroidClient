package com.example.mylibraryapp.domain.repository

import com.example.mylibraryapp.data.remote.dto.AuthorDTO
import com.example.mylibraryapp.domain.model.Author

interface MyLibraryRepository {

    // ----- AUTHOR -----

    suspend fun getAllAuthor() : List<AuthorDTO>

    suspend fun getAuthor(id: Int) : AuthorDTO

    suspend fun createAuthor(author: Author)

    suspend fun updateAuthor(author: Author)

    suspend fun deleteAuthor(id: Int)

    // ----- AUTHOR END -----


}