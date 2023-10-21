package com.example.mylibraryapp.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
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
import androidx.navigation.compose.rememberNavController
import com.example.mylibraryapp.presentation.author.AuthorScreen
import com.example.mylibraryapp.presentation.author.listscreen.NewAuthorScreen
import com.example.mylibraryapp.presentation.book.listscreen.BookScreen
import com.example.mylibraryapp.presentation.loan.listscreen.LoanScreen
import com.example.mylibraryapp.presentation.login.LoginScreen


@Composable
fun MainScreen() {

    val navController = rememberNavController()
//    val navBackStackEntry by navController.currentBackStackEntryAsState()

//    val navDestination = navBackStackEntry?.destination


    val items = listOf(
        Destinations.Book,
        Destinations.Loan,
        Destinations.Settings
    )

    val isInBottomBar = navController.currentBackStackEntryAsState().value?.destination?.route in items.map { it.route }

            Scaffold(
        bottomBar = {
//            if (navDestination?.route != Destinations.Login.route) {
//                BottomBar(navHostController = navController, navDestination = navDestination)
//            }
            if (isInBottomBar) {
                BottomBar(navHostController = navController, items)
            }

        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            BottomNavigation(navHostController = navController)
        }

    }
}

@Composable
fun BottomBar(navHostController: NavHostController, destinations: List<Destinations>){
//    val items = listOf(
//        Destinations.Book,
//        Destinations.Loan,
//        Destinations.Settings
//    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val navDestination = navBackStackEntry?.destination

    NavigationBar {
        destinations.forEach { item ->

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
        startDestination = Destinations.Login.route
    ) {

        composable(Destinations.Login.route) {
            LoginScreen(navHostController)
        }

        composable(Destinations.Book.route) {
            BookScreen()
        }

        composable(Destinations.Loan.route) {
            LoanScreen()
        }

        composable(Destinations.Settings.route) {
            // Todo: Remove this later, it is just for testing.
            NewAuthorScreen()
        }
    }
}
