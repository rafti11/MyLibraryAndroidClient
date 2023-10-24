package com.example.mylibraryapp.presentation.book.listscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mylibraryapp.common.Resource
import com.example.mylibraryapp.data.remote.dto.toBook
import com.example.mylibraryapp.domain.network.AuthResult
import com.example.mylibraryapp.domain.repository.MyLibraryRepository
import com.example.mylibraryapp.domain.usecase.book.GetAllBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    private val getAllBooksUseCase: GetAllBooksUseCase,
    private val repository: MyLibraryRepository
) : ViewModel() {

    private var _state = mutableStateOf(BookListState())
    val state: State<BookListState> = _state

    init {
        getAllBooks()
    }


    private fun getAllBooks() {

        viewModelScope.launch{

            _state.value = _state.value.copy(isLoading = true)

            val result = repository.getAllBooks()

            when(result) {
                is AuthResult.Authorized -> {
                    val books = result.data?.map {
                        it.toBook()
                    }
                    _state.value = _state.value.copy(list = books ?: emptyList())
                }
                is AuthResult.Unauthorized -> {
                    _state.value = _state.value.copy(error = "Unauthorized")
                }
                is AuthResult.Error -> {
                    _state.value = _state.value.copy(error = "error book")
                }
            }

            _state.value = _state.value.copy(isLoading = false)

        }

    }
}