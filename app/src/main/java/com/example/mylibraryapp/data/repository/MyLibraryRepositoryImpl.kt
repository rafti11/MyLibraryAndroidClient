package com.example.mylibraryapp.data.repository

import com.example.mylibraryapp.common.Tags
import com.example.mylibraryapp.data.SharedPreferencesManager
import com.example.mylibraryapp.data.remote.LibraryAPI
import com.example.mylibraryapp.data.remote.dto.AuthenticationResponseDTO
import com.example.mylibraryapp.data.remote.dto.AuthorDTO
import com.example.mylibraryapp.data.remote.dto.BookDTO
import com.example.mylibraryapp.data.remote.dto.LoanDTO
import com.example.mylibraryapp.domain.model.Author
import com.example.mylibraryapp.domain.model.LoginRequest
import com.example.mylibraryapp.domain.network.AuthResult
import com.example.mylibraryapp.domain.repository.MyLibraryRepository
import retrofit2.HttpException
import javax.inject.Inject

class MyLibraryRepositoryImpl @Inject constructor(
    private val api: LibraryAPI,
    private val sharedPreferencesManager: SharedPreferencesManager
) : MyLibraryRepository {

    // ----- AUTHENTICATE -----

    override suspend fun login(loginRequest: LoginRequest): AuthResult<AuthenticationResponseDTO> {

        return api.login(loginRequest)

    }

    override suspend fun isTokenValid(): AuthResult<Unit> {
        val token = sharedPreferencesManager.get(Tags.TOKEN)
        return api.isTokenValid(token = "Bearer $token")
    }


    // ----- AUTHENTICATE END -----

    // ----- BOOK -----

    override suspend fun getAllBooks(): AuthResult<List<BookDTO>> {
        val token = sharedPreferencesManager.get(Tags.TOKEN)
        return api.getAllBooks(token = "Bearer $token")
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