package com.example.mylibraryapp.presentation.login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoginAllowed: Boolean = false
) {

    fun isFormValid(): Boolean {
        return !(email.isEmpty() || password.isEmpty())
    }
}