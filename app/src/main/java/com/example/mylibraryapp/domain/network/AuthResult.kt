package com.example.mylibraryapp.domain.network

sealed class AuthResult<T>(val data: T? = null) {
    class Authorized<T>(data: T? = null) : AuthResult<T>(data)
    class Unauthorized<T> : AuthResult<T>()
    class Error<T> : AuthResult<T>()
}