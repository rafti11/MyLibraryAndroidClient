package com.example.mylibraryapp.presentation.loan.listscreen


import com.example.mylibraryapp.domain.model.Loan

data class LoanListState(
    val isLoading: Boolean = false,
    val list: List<Loan> = emptyList(),
    val error: String? = null
)