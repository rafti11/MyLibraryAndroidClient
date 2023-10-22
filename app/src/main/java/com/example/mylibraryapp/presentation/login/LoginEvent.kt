package com.example.mylibraryapp.presentation.login

import androidx.navigation.NavHostController

sealed class LoginEvent {

    class EmailChanged(val email: String) : LoginEvent()
    class PasswordChanged(val password: String) : LoginEvent()
    class Login(val navHostController: NavHostController) : LoginEvent()

}