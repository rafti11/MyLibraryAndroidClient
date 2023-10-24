package com.example.mylibraryapp.domain.usecase.book

import com.example.mylibraryapp.common.Resource
import com.example.mylibraryapp.data.remote.dto.toAuthor
import com.example.mylibraryapp.data.remote.dto.toBook
import com.example.mylibraryapp.domain.model.Author
import com.example.mylibraryapp.domain.model.Book
import com.example.mylibraryapp.domain.repository.MyLibraryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllBooksUseCase @Inject constructor(
    private val repository: MyLibraryRepository
) {

    operator fun invoke() : Flow<Resource<List<Book>>> = flow {

//        try {
//
//            emit(Resource.Loading())
//            val data = repository.getAllBooks()
//            val list = data.map { bookDTO ->
//                bookDTO.toBook()
//            }
//            emit(Resource.Success(data = list))
//
//        } catch (e: Exception) {
//
//            emit(Resource.Error(e.localizedMessage ?: "error GetAllBooksUseCase"))
//
//        }
    }
}