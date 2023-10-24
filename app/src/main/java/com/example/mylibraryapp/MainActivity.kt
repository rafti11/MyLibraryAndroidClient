package com.example.mylibraryapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.mylibraryapp.di.AppModule
import com.example.mylibraryapp.domain.usecase.author.GetAllAuthorsUseCase
import com.example.mylibraryapp.presentation.author.listscreen.AuthorListViewModel
import com.example.mylibraryapp.presentation.author.listscreen.NewAuthorScreen
import com.example.mylibraryapp.presentation.book.listscreen.BookScreen
import com.example.mylibraryapp.presentation.loan.listscreen.LoanScreen
import com.example.mylibraryapp.presentation.login.LoginScreen
import com.example.mylibraryapp.presentation.navigation.BottomBar
import com.example.mylibraryapp.presentation.navigation.BottomNavigation
import com.example.mylibraryapp.presentation.navigation.MainScreen
import com.example.mylibraryapp.presentation.theme.MyLibraryAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            MainScreen()


            MyLibraryAppTheme {

//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
////                    Greeting("Android")
////                    AddBookScreen()
////                    AuthorScreen2()
////                    NewAuthorScreen()
////                    BookItem()
////                    TestGrid()
////                    BookScreen()
//                    LoanScreen()
//                    LoginScreen()
//                }


            }
        }






//        val list = listOf<String>("manolo", "pepe", "manuel", "perez", "juan", "amante")
//
//        println(list.filter { it.contains("man") })
//
//        val api = AppModule.provideLibraryAPI()
//        val repository = AppModule.provideMyLibraryRepository(api)
//
//        println(api.toString())
//        lifecycleScope.launch {
//
////            repository.deleteAuthor(4)
//
//            val data = repository.getAllBooks()
//
//            println(data)
//        }



    }
}
