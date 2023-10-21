package com.example.mylibraryapp.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylibraryapp.common.Resource
import com.example.mylibraryapp.common.Tags
import com.example.mylibraryapp.data.SharedPreferencesManager
import com.example.mylibraryapp.data.remote.dto.toAuthenticationResponse
import com.example.mylibraryapp.domain.model.LoginRequest
import com.example.mylibraryapp.domain.usecase.login.GetTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase,
    private val sharedPreferencesManager: SharedPreferencesManager
) : ViewModel() {

    private var _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state


    fun handleEvent(loginEvent: LoginEvent) {
        when(loginEvent) {
            is LoginEvent.EmailChanged -> {
                updateEmail(loginEvent.email)
            }
            is LoginEvent.PasswordChanged -> {
                updatePassword(loginEvent.password)
            }
            is LoginEvent.Login -> {
//                login()
                login2()
            }
        }
    }

    private fun updateEmail(email: String) {
        _state.value = _state.value.copy(email = email)
    }

    private fun updatePassword(password: String) {
        _state.value = _state.value.copy(password = password)
    }

    private fun login2() {
        _state.value = _state.value.copy(isLoginAllowed = true)

    }

    private fun login() {


        val email = _state.value.email
        val password = _state.value.password
        println(email)
        println(password)

        getTokenUseCase.invoke(LoginRequest(email, password)).onEach { resource ->

            when(resource) {

                is Resource.Loading -> {
                    println("Loading LoginViewModel")
                    _state.value = LoginState(isLoading = true)
                    // Todo: Later remove this.
//                    delay(5000)
                }
                is Resource.Success -> {
                    println("Success LoginViewModel")


                    if (resource.data != null) {
                        val auth = resource.data.toAuthenticationResponse()
                        _state.value = LoginState(authenticationResponse = auth)

                        if (auth.token.isNotEmpty()) {
                            sharedPreferencesManager.save(Tags.TOKEN, auth.token)

                            println("token: ${sharedPreferencesManager.get(Tags.TOKEN)}")
                        }

                    }
//                    _state.value = LoginState(authenticationResponse = resource.data?.toAuthenticationResponse() ?: AuthenticationResponse(""))

//                    println("token: ${state.value.authenticationResponse?.token}")
                }
                is Resource.Error -> {
                    println("Error LoginViewModel")
                    _state.value = LoginState(error = resource.message)
                    println(state.value.error)
                }

            }

        }.launchIn(viewModelScope)


    }
}