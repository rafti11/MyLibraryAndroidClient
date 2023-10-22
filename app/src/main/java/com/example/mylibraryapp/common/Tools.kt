package com.example.mylibraryapp.common

import com.auth0.jwt.JWT
import com.auth0.jwt.interfaces.DecodedJWT
import java.util.Date

class Tools {

    companion object {

        fun isTokenValid(token: String) : Boolean{

            val decodedJWT = JWT.decode(token)
            val time = decodedJWT.expiresAt
//            println("token time: $time")
//            println("actual Date: ${Date()}")
            return time.after(Date())

        }

    }




}