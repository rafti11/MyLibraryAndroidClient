package com.example.mylibraryapp.domain.network

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class AuthResultCallAdapter(
    private val type: Type
) : CallAdapter<Type, AuthResultCall<Type>> {

    override fun responseType(): Type {
        return type
    }

    override fun adapt(call: Call<Type>): AuthResultCall<Type> {
        return AuthResultCall(call)
    }
}