package com.example.mylibraryapp.data.remote.dto

import com.example.mylibraryapp.domain.model.AuthenticationResponse

data class AuthenticationResponseDTO (
    val token: String
)

fun AuthenticationResponseDTO.toAuthenticationResponse() : AuthenticationResponse {
    return AuthenticationResponse(token)
}