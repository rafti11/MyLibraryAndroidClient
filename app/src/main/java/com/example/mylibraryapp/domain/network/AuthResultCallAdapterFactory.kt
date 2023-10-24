package com.example.mylibraryapp.domain.network

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class AuthResultCallAdapterFactory() : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java) {
            return null
        }

        val getType = getParameterUpperBound(0, returnType as ParameterizedType)

        if (getRawType(getType) != AuthResult::class.java) {
            return null
        }

        val result = getParameterUpperBound(0, getType as ParameterizedType)
        return AuthResultCallAdapter(result)

    }


}