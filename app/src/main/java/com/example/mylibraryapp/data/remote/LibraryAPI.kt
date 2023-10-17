package com.example.mylibraryapp.data.remote

import com.example.mylibraryapp.data.remote.dto.AuthorDTO
import com.example.mylibraryapp.data.remote.dto.BookDTO
import com.example.mylibraryapp.domain.model.Author
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface LibraryAPI {

    // ----- BOOK -----

    @GET("book/all")
    suspend fun getAllBooks() : List<BookDTO>

    // ----- BOOK END -----

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