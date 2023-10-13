package com.example.mylibraryapp.presentation.author.listscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylibraryapp.common.Resource
import com.example.mylibraryapp.di.AppModule
import com.example.mylibraryapp.domain.model.Author
import com.example.mylibraryapp.domain.usecase.author.GetAllAuthorsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorListViewModel @Inject constructor(
    private val getAllAuthorsUseCase: GetAllAuthorsUseCase
) : ViewModel() {

    private var _state = mutableStateOf(AuthorListState())
    val state: State<AuthorListState> = _state

    init {
        getAllAuthor()
    }


    private fun getAllAuthor() {

        getAllAuthorsUseCase().onEach { resource ->

            when(resource) {

                is Resource.Loading -> {
                    println("Loading AuthorListViewModel")
                    _state.value = AuthorListState(isLoading = true)
                    // Todo: Later remove this.
//                    delay(5000)
                }
                is Resource.Success -> {
                    println("Success AuthorListViewModel")
                    _state.value = AuthorListState(list = resource.data ?: emptyList())
                }
                is Resource.Error -> {
                    println("Error AuthorListViewModel")
                    _state.value = AuthorListState(error = resource.message)
                }

            }

        }.launchIn(viewModelScope)

    }
}