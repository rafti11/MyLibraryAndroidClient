package com.example.mylibraryapp.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mylibraryapp.presentation.author.AuthorScreen
import com.example.mylibraryapp.presentation.author.listscreen.NewAuthorScreen
import com.example.mylibraryapp.presentation.book.listscreen.BookScreen
import com.example.mylibraryapp.presentation.loan.listscreen.LoanScreen


@Composable
fun BottomBar(navHostController: NavHostController){

    val items = listOf(
        Destinations.BookD,
        Destinations.LoanD,
        Destinations.SettingsD
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val navDestination = navBackStackEntry?.destination

    NavigationBar {
        items.forEach { item ->

            AddNavigationItem(
                screen = item,
                navHostController = navHostController,
                navDestination = navDestination
            )

        }
    }
}

@Composable
fun RowScope.AddNavigationItem(
    screen: Destinations,
    navHostController: NavHostController,
    navDestination: NavDestination?
) {
    NavigationBarItem(
        label = {
            Text(text = screen.name)
                },
        icon = {
            Icon(
                imageVector = screen.selectedIcon,
                contentDescription = screen.name
            )
        },
        selected = navDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navHostController.navigate(screen.route)
        }
    )

}

@Composable
fun BottomNavigation(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        startDestination = Destinations.BookD.route
    ) {

        composable(Destinations.BookD.route) {
            BookScreen()
        }

        composable(Destinations.LoanD.route) {
            LoanScreen()
        }

        composable(Destinations.SettingsD.route) {
            // Todo: Remove this later, it is just for testing.
            NewAuthorScreen()
        }
    }
}
