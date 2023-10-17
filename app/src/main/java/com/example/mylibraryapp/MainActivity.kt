package com.example.mylibraryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mylibraryapp.di.AppModule
import com.example.mylibraryapp.domain.usecase.author.GetAllAuthorsUseCase
import com.example.mylibraryapp.presentation.author.listscreen.AuthorListViewModel
import com.example.mylibraryapp.presentation.author.listscreen.NewAuthorScreen
import com.example.mylibraryapp.presentation.book.common.BookItem
import com.example.mylibraryapp.presentation.book.common.TestGrid
import com.example.mylibraryapp.presentation.book.listscreen.BookScreen
import com.example.mylibraryapp.presentation.loan.listscreen.LoanScreen
import com.example.mylibraryapp.presentation.theme.MyLibraryAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLibraryAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    AddBookScreen()
//                    AuthorScreen2()
//                    NewAuthorScreen()
//                    BookItem()
//                    TestGrid()
//                    BookScreen()
                    LoanScreen()
                }
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyLibraryAppTheme {
        Greeting("Android")
    }
}