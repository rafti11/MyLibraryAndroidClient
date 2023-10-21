package com.example.mylibraryapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dehaze
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Feed
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations (
    val name: String,
    val route: String,
    val selectedIcon: ImageVector
) {

    object Login : Destinations(
        name = "Login",
        route = "login",
        selectedIcon = Icons.Default.Place
    )

    object Book : Destinations(
        name = "Book",
        route = "book",
        selectedIcon = Icons.Default.LibraryBooks
    )

    object Loan : Destinations(
        name = "Loan",
        route = "loan",
        selectedIcon = Icons.Default.Dehaze
    )

    object Settings : Destinations(
        name = "Settings",
        route = "settings",
        selectedIcon = Icons.Default.Settings
    )
}