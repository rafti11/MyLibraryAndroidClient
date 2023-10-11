package com.example.mylibraryapp.presentation.author

sealed class AuthorRegistrationEvent {

    class NameChanged(val name: String) : AuthorRegistrationEvent()

    object Submit : AuthorRegistrationEvent()
}