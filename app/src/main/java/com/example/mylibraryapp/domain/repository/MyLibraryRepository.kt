package com.example.mylibraryapp.domain.repository

import com.example.mylibraryapp.data.remote.dto.AuthorDTO
import com.example.mylibraryapp.data.remote.dto.BookDTO
import com.example.mylibraryapp.data.remote.dto.LoanDTO
import com.example.mylibraryapp.domain.model.Author

interface MyLibraryRepository {

    // ----- BOOK -----
    suspend fun getAllBooks() : List<BookDTO>

    // ----- BOOK END -----


    // ----- LOAN -----
    suspend fun getAllLoansByClientID(id: Int) : List<LoanDTO>

    // ----- LOAN END -----


    // ----- AUTHOR -----

    suspend fun getAllAuthor() : List<AuthorDTO>

    suspend fun getAuthor(id: Int) : AuthorDTO

    suspend fun createAuthor(author: Author)

    suspend fun updateAuthor(author: Author)

    suspend fun deleteAuthor(id: Int)

    // ----- AUTHOR END -----


}