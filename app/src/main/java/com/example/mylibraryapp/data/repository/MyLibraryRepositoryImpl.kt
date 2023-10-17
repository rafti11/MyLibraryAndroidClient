package com.example.mylibraryapp.data.repository

import com.example.mylibraryapp.data.remote.LibraryAPI
import com.example.mylibraryapp.data.remote.dto.AuthorDTO
import com.example.mylibraryapp.data.remote.dto.BookDTO
import com.example.mylibraryapp.data.remote.dto.LoanDTO
import com.example.mylibraryapp.domain.model.Author
import com.example.mylibraryapp.domain.repository.MyLibraryRepository
import javax.inject.Inject

class MyLibraryRepositoryImpl @Inject constructor(
    private val api: LibraryAPI
) : MyLibraryRepository {

    // ----- BOOK -----

    override suspend fun getAllBooks(): List<BookDTO> {
        return api.getAllBooks()
    }

    // ----- BOOK END -----


    // ----- LOAN -----
    override suspend fun getAllLoansByClientID(id: Int): List<LoanDTO> {
        return api.getAllLoansByClientID(id)
    }

    // ----- LOAN END -----


    // ----- AUTHOR -----

    override suspend fun getAllAuthor(): List<AuthorDTO> {
        return api.getAllAuthor()
    }

    override suspend fun getAuthor(id: Int): AuthorDTO {
        return api.getAuthor(id)
    }

    override suspend fun createAuthor(author: Author) {
        api.createAuthor(author)
    }

    override suspend fun updateAuthor(author: Author) {
        api.updateAuthor(author)
    }

    override suspend fun deleteAuthor(id: Int) {
        api.deleteAuthor(id)
    }

    // ----- AUTHOR END -----

}