package com.example.mylibraryapp.data.remote.dto

import com.example.mylibraryapp.domain.model.Loan

data class LoanDTO (
    val dateOut: String,
    val dateReturned: String,
    val dateDue: String,
    val title: String
)

fun LoanDTO.toLoan() : Loan {

    return Loan(dateOut = dateOut, dateReturned = dateReturned, dateDue = dateDue, bookTitle = title)

}