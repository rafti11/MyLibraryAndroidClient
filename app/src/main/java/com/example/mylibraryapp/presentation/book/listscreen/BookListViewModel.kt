package com.example.mylibraryapp.presentation.book.listscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylibraryapp.common.Resource
import com.example.mylibraryapp.domain.usecase.book.GetAllBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    private val getAllBooksUseCase: GetAllBooksUseCase
) : ViewModel() {

    private var _state = mutableStateOf(BookListState())
    val state: State<BookListState> = _state

    init {
        getAllBooks()
    }


    private fun getAllBooks() {

        getAllBooksUseCase().onEach { resource ->

            when(resource) {

                is Resource.Loading -> {
                    println("Loading BookListViewModel")
                    _state.value = BookListState(isLoading = true)
                    // Todo: Later remove this.
//                    delay(5000)
                }
                is Resource.Success -> {
                    println("Success BookListViewModel")
                    _state.value = BookListState(list = resource.data ?: emptyList())
                }
                is Resource.Error -> {
                    println("Error BookListViewModel")
                    _state.value = BookListState(error = resource.message)
                }

            }

        }.launchIn(viewModelScope)

    }
}