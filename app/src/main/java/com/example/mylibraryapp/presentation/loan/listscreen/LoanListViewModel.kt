package com.example.mylibraryapp.presentation.loan.listscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylibraryapp.common.Resource
import com.example.mylibraryapp.common.Tags
import com.example.mylibraryapp.data.SharedPreferencesManager
import com.example.mylibraryapp.data.remote.dto.toBook
import com.example.mylibraryapp.data.remote.dto.toLoan
import com.example.mylibraryapp.domain.network.AuthResult
import com.example.mylibraryapp.domain.repository.MyLibraryRepository
import com.example.mylibraryapp.domain.usecase.loan.GetAllLoansByClientIDUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoanListViewModel @Inject constructor(
    private val getAllLoansByClientIDUseCase: GetAllLoansByClientIDUseCase,
    private val repository: MyLibraryRepository,
    private val sharedPreferencesManager: SharedPreferencesManager
) : ViewModel() {

    private var _state = mutableStateOf(LoanListState())
    val state: State<LoanListState> = _state

    init {
        getAllLoans(sharedPreferencesManager.getInt(Tags.USER_ID))
    }


    private fun getAllLoans(id: Int) {



        viewModelScope.launch{

            val result = repository.getAllLoansByClientID(id)


            when(result) {
                is AuthResult.Authorized -> {
                    val loans = result.data?.map {
                        it.toLoan()
                    }
                    println(loans)
                    _state.value = _state.value.copy(list = loans ?: emptyList())
                }
                is AuthResult.Unauthorized -> {
                    _state.value = _state.value.copy(error = "Unauthorized")
                }
                is AuthResult.Error -> {
                    _state.value = _state.value.copy(error = "error book")
                }
            }

        }


//        getAllLoansByClientIDUseCase(id).onEach { resource ->
//
//            when(resource) {
//
//                is Resource.Loading -> {
//                    println("Loading LoanListViewModel")
//                    _state.value = LoanListState(isLoading = true)
//                    // Todo: Later remove this.
////                    delay(5000)
//                }
//                is Resource.Success -> {
//                    println("Success LoanListViewModel")
//                    _state.value = LoanListState(list = resource.data ?: emptyList())
//                }
//                is Resource.Error -> {
//                    println("Error LoanListViewModel")
//                    _state.value = LoanListState(error = resource.message)
//                }
//
//            }
//
//        }.launchIn(viewModelScope)

    }
}