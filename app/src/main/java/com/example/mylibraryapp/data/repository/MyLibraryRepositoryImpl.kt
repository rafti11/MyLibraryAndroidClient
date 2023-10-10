package com.example.mylibraryapp.data.repository

import com.example.mylibraryapp.data.remote.LibraryAPI
import com.example.mylibraryapp.data.remote.dto.AuthorDTO
import com.example.mylibraryapp.domain.model.Author
import com.example.mylibraryapp.domain.repository.MyLibraryRepository
import javax.inject.Inject

class MyLibraryRepositoryImpl @Inject constructor(
    private val api: LibraryAPI
) : MyLibraryRepository {

    override suspend fun getAllAuthor(): List<AuthorDTO> {
        return api.getAllAuthor()
    }

    override suspend fun getAuthor(id: Int): AuthorDTO {
        return api.getAuthor(id);
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


}