package com.example.mylibraryapp.domain.usecase.author

import com.example.mylibraryapp.common.Resource
import com.example.mylibraryapp.data.remote.dto.toAuthor
import com.example.mylibraryapp.domain.model.Author
import com.example.mylibraryapp.domain.repository.MyLibraryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllAuthorsUseCase @Inject constructor(
    private val repository: MyLibraryRepository
) {

    operator fun invoke() : Flow<Resource<List<Author>>> = flow {

        try {

            emit(Resource.Loading())
            val data = repository.getAllAuthor()
            val list = data.map { authorDTO ->
                authorDTO.toAuthor()
            }
            emit(Resource.Success(data = list))

        } catch (e: Exception) {

            emit(Resource.Error(e.localizedMessage ?: "error GetAllAuthorsUseCase"))

        }
    }
}