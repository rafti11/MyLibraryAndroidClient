package com.example.mylibraryapp.presentation.author

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylibraryapp.di.AppModule
import com.example.mylibraryapp.domain.model.Author
import kotlinx.coroutines.launch

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
        val name = _state.value.name
        println(name)

        val api = AppModule.provideLibraryAPI()
//        val repository = AppModule.provideMyLibraryRepository(api)
//
//        viewModelScope.launch {
//
//            if (name != null) {
//                repository.createAuthor(Author(id = null, name = name))
//            }
//
//
//
//
//
//        }

    }
}