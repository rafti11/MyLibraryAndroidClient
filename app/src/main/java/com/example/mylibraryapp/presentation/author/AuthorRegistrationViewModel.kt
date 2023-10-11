package com.example.mylibraryapp.presentation.author

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AuthorRegistrationViewModel : ViewModel() {

    private var _state = mutableStateOf(AuthorRegistrationState())
    val state: State<AuthorRegistrationState> = _state


    fun handleEvent(authorRegistrationEvent: AuthorRegistrationEvent) {
        when(authorRegistrationEvent) {
            is AuthorRegistrationEvent.NameChanged -> {
                updateName(authorRegistrationEvent.name)
            }
            is AuthorRegistrationEvent.Submit -> {
                submit()
            }
        }
    }

    private fun updateName(name: String) {
        _state.value = _state.value.copy(name = name)
    }

    private fun submit() {
        println(_state.value.name)
    }
}