package com.example.mylibraryapp.presentation.loan.listscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylibraryapp.common.Resource
import com.example.mylibraryapp.domain.usecase.loan.GetAllLoansByClientIDUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoanListViewModel @Inject constructor(
    private val getAllLoansByClientIDUseCase: GetAllLoansByClientIDUseCase
) : ViewModel() {

    private var _state = mutableStateOf(LoanListState())
    val state: State<LoanListState> = _state

    init {
        // TODO: In future get id from session o other way
        getAllLoans(1)
    }


    private fun getAllLoans(id: Int) {

        getAllLoansByClientIDUseCase(id).onEach { resource ->

            when(resource) {

                is Resource.Loading -> {
                    println("Loading LoanListViewModel")
                    _state.value = LoanListState(isLoading = true)
                    // Todo: Later remove this.
//                    delay(5000)
                }
                is Resource.Success -> {
                    println("Success LoanListViewModel")
                    _state.value = LoanListState(list = resource.data ?: emptyList())
                }
                is Resource.Error -> {
                    println("Error LoanListViewModel")
                    _state.value = LoanListState(error = resource.message)
                }

            }

        }.launchIn(viewModelScope)

    }
}