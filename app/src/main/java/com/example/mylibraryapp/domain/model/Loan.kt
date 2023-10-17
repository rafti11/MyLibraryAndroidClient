package com.example.mylibraryapp.domain.model

data class Loan (
    val dateOut: String,
    val dateReturned: String,
    val dateDue: String,
    val bookTitle: String,
//    val bookId: Int
    )