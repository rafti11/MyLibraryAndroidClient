package com.example.mylibraryapp.data.remote

import com.example.mylibraryapp.data.remote.dto.AuthenticationResponseDTO
import com.example.mylibraryapp.data.remote.dto.AuthorDTO
import com.example.mylibraryapp.data.remote.dto.BookDTO
import com.example.mylibraryapp.data.remote.dto.LoanDTO
import com.example.mylibraryapp.domain.model.Author
import com.example.mylibraryapp.domain.model.LoginRequest
import com.example.mylibraryapp.domain.network.AuthResult
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface LibraryAPI {

    // ----- AUTHENTICATE -----

    @POST("auth/authenticate")
    suspend fun login(@Body loginRequest: LoginRequest) : AuthResult<AuthenticationResponseDTO>

    @GET("auth/istokenvalid")
    suspend fun isTokenValid(@Header("Authorization") token: String) : AuthResult<Unit>

    // ----- AUTHENTICATE END -----


    // ----- BOOK -----

    @GET("book/all")
    suspend fun getAllBooks(@Header("Authorization") token: String) : AuthResult<List<BookDTO>>

    // ----- BOOK END -----

    // ----- LOAN -----

    @GET("loan/client/{id}")
    suspend fun getAllLoansByClientID(@Header("Authorization") token: String, @Path("id") id: Int) : AuthResult<List<LoanDTO>>

    // ----- LOAN END -----

    // ----- AUTHOR -----

    @GET("author/all")
    suspend fun getAllAuthor() : List<AuthorDTO>

    @GET("author/{id}")
    suspend fun getAuthor(@Path("id") id: Int) : AuthorDTO

    @POST("author/create")
    suspend fun createAuthor(@Body author: Author)

    @PUT("author/update")
    suspend fun updateAuthor(@Body author: Author)

    @DELETE("author/delete/{id}")
    suspend fun deleteAuthor(@Path("id") id: Int)

    // ----- AUTHOR END -----


}