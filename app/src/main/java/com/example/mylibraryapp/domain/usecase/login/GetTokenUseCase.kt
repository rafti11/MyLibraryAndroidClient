package com.example.mylibraryapp.domain.usecase.login

import com.example.mylibraryapp.common.Resource
import com.example.mylibraryapp.common.Tags
import com.example.mylibraryapp.data.SharedPreferencesManager
import com.example.mylibraryapp.data.remote.dto.AuthenticationResponseDTO
import com.example.mylibraryapp.data.remote.dto.toAuthor
import com.example.mylibraryapp.domain.model.LoginRequest
import com.example.mylibraryapp.domain.network.AuthResult
import com.example.mylibraryapp.domain.repository.MyLibraryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(
    private val repository: MyLibraryRepository,
    private val sharedPreferencesManager: SharedPreferencesManager
) {

//    operator fun invoke(loginRequest: LoginRequest) : Flow<Resource<AuthenticationResponseDTO>> = flow {
//
//        // TODO: Check this later, maybe could be deleted.
//        try {
//
//            emit(Resource.Loading())
//            val result = repository.login(loginRequest)
//
//            when(result) {
//                is AuthResult.Authorized -> {
//                    sharedPreferencesManager.save(Tags.TOKEN, result.data?.token ?: "")
//                    emit(Resource.Success(data = result.data ?: AuthenticationResponseDTO("")))
//                }
//                is AuthResult.Unauthorized -> {
//                    emit(Resource.Error(message = "Unauthorized"))
//                }
//                is AuthResult.Error -> {
//                    emit(Resource.Error(message = "Error found"))
//                }
//            }
//
//
//        } catch (e: Exception) {
//
//            emit(Resource.Error(e.localizedMessage ?: "error GetTokenUseCase"))
//
//        }
//    }
}