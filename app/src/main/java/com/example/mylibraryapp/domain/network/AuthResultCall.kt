package com.example.mylibraryapp.domain.network

import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class AuthResultCall<T : Any>(
    private val call: Call<T>
) : Call<AuthResult<T>> {
    override fun clone(): Call<AuthResult<T>> {
        return AuthResultCall(call.clone())
    }

    override fun execute(): Response<AuthResult<T>> {
        throw UnsupportedOperationException("AuthResultCall do not support this feature")
    }

    override fun isExecuted(): Boolean {
        return call.isExecuted
    }

    override fun cancel() {
        call.cancel()
    }

    override fun isCanceled(): Boolean {
        return call.isCanceled
    }

    override fun request(): Request {
        return call.request()
    }

    override fun timeout(): Timeout {
        return call.timeout()
    }

    override fun enqueue(callback: Callback<AuthResult<T>>) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val code = response.code()
                val body = response.body()

                if (response.isSuccessful) {
                    if (body != null) {
                        callback.onResponse(
                            this@AuthResultCall,
                            Response.success(AuthResult.Authorized(data = body))
                        )
                    } else {
                        callback.onResponse(
                            this@AuthResultCall,
                            Response.success(AuthResult.Authorized())
                        )
                    }
                } else {
                    if (code == 401) {
                        callback.onResponse(
                            this@AuthResultCall,
                            Response.success(AuthResult.Unauthorized())
                        )
                    } else {
                        callback.onResponse(
                            this@AuthResultCall,
                            Response.success(AuthResult.Error())
                        )
                    }
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                val result = when (t) {
                    is HttpException -> {
                        if (t.code() == 401) {
                            AuthResult.Unauthorized<T>()
                        } else {
                            AuthResult.Error()
                        }
                    }

                    else -> AuthResult.Error()

                }
                callback.onResponse(this@AuthResultCall, Response.success(result))
            }
        })
    }
}