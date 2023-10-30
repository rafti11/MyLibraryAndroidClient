package com.example.mylibraryapp.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylibraryapp.common.Tags
import com.example.mylibraryapp.data.SharedPreferencesManager
import com.example.mylibraryapp.data.remote.dto.AuthenticationResponseDTO
import com.example.mylibraryapp.domain.model.LoginRequest
import com.example.mylibraryapp.domain.network.AuthResult
import com.example.mylibraryapp.domain.repository.MyLibraryRepository
import com.example.mylibraryapp.domain.usecase.login.GetTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase,
    private val sharedPreferencesManager: SharedPreferencesManager,
    private val repository: MyLibraryRepository
) : ViewModel() {

    private var _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    private val resultChannel = Channel<AuthResult<AuthenticationResponseDTO>>()
    val authResult = resultChannel.receiveAsFlow()

    private val resultChannel2 = Channel<AuthResult<Unit>>()
    val authResult2 = resultChannel2.receiveAsFlow()

    init {
        isTokenValid()
    }

    fun handleEvent(loginEvent: LoginEvent) {
        when(loginEvent) {
            is LoginEvent.EmailChanged -> {
                updateEmail(loginEvent.email)
            }
            is LoginEvent.PasswordChanged -> {
                updatePassword(loginEvent.password)
            }
            is LoginEvent.Login -> {
                login()
//                login3()
            }
        }
    }

    private fun updateEmail(email: String) {
        _state.value = _state.value.copy(email = email)
    }

    private fun updatePassword(password: String) {
        _state.value = _state.value.copy(password = password)
    }


    private fun login() {



        viewModelScope.launch {

            _state.value = _state.value.copy(isLoading = true)

            val result = repository.login(LoginRequest(state.value.email, state.value.password))

            if (result.data != null) {
                sharedPreferencesManager.save(Tags.TOKEN, result.data.token)
                sharedPreferencesManager.save(Tags.USER_ID, result.data.userID)
            }

            resultChannel.send(result)

            _state.value = _state.value.copy(isLoading = false)
        }


//        viewModelScope.launch {
//            _state.value = _state.value.copy(isLoading = true)
//
////            val result = repository.login(LoginRequest(state.value.email, state.value.password))
////
////            when(result) {
////                is AuthResult.Authorized -> {
////                    sharedPreferencesManager.save(Tags.TOKEN, result.data?.token ?: "")
////                    println(result.data)
////                }
////                is AuthResult.Unauthorized -> {
////                    println("Unauthorized")
////                }
////                is AuthResult.Error -> {
////                    println("error result.data")
////                }
////            }
////            println(result)
////            val  result2 = repository.isTokenValid()
////
////            when(result2) {
////                is AuthResult.Authorized -> {
////                    println(result2.data)
////                }
////                is AuthResult.Unauthorized -> {
////                    println("r2 Unauthorized")
////                }
////                is AuthResult.Error -> {
////                    println("r2 error result.data")
////                }
////            }
////            println(result2)
//
//
//            _state.value = _state.value.copy(isLoading = false)
//        }


    }

    private fun isTokenValid() {

        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            val result = repository.isTokenValid()
            resultChannel2.send(result)
            _state.value = _state.value.copy(isLoading = false)

        }

    }

}