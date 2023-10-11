package com.example.mylibraryapp.presentation.author

data class AuthorRegistrationState(
    val name: String? = null,
    val isLoading: Boolean = false,
    val error: String? = null
) {

    // Todo: Check this later
    fun isFormValid(): Boolean {
        return name?.isNotEmpty() ?: false
    }
}