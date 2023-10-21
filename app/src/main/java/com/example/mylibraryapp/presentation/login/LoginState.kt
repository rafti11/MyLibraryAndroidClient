package com.example.mylibraryapp.presentation.login

import com.example.mylibraryapp.domain.model.AuthenticationResponse

data class LoginState(
    val email: String = "",
    val password: String = "",
    val authenticationResponse: AuthenticationResponse? = null,
    val isLoading: Boolean = false,
    val isLoginAllowed: Boolean = false,
    val error: String? = null
) {

    fun isFormValid(): Boolean {
        return !(email.isNullOrEmpty() || password.isNullOrEmpty())
    }
}