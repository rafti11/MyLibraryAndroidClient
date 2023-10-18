package com.example.mylibraryapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations (
    val name: String,
    val route: String,
    val selectedIcon: ImageVector
) {
    object BookD : Destinations(
        name = "Book",
        route = "book",
        selectedIcon = Icons.Default.Place
    )

    object LoanD : Destinations(
        name = "Loan",
        route = "loan",
        selectedIcon = Icons.Default.Favorite
    )

    object SettingsD : Destinations(
        name = "Settings",
        route = "settings",
        selectedIcon = Icons.Default.Settings
    )
}