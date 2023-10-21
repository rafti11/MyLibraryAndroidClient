package com.example.mylibraryapp.presentation.login

sealed class LoginEvent {

    class EmailChanged(val email: String) : LoginEvent()
    class PasswordChanged(val password: String) : LoginEvent()

    object Login : LoginEvent()
}