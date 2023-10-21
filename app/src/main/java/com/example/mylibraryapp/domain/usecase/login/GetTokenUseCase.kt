package com.example.mylibraryapp.domain.usecase.login

import com.example.mylibraryapp.common.Resource
import com.example.mylibraryapp.data.remote.dto.AuthenticationResponseDTO
import com.example.mylibraryapp.data.remote.dto.toAuthor
import com.example.mylibraryapp.domain.model.LoginRequest
import com.example.mylibraryapp.domain.repository.MyLibraryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(
    private val repository: MyLibraryRepository
) {

    operator fun invoke(loginRequest: LoginRequest) : Flow<Resource<AuthenticationResponseDTO>> = flow {

        try {

            emit(Resource.Loading())
            val data = repository.login(loginRequest)
            emit(Resource.Success(data = data))

        } catch (e: Exception) {

            emit(Resource.Error(e.localizedMessage ?: "error GetTokenUseCase"))

        }
    }
}