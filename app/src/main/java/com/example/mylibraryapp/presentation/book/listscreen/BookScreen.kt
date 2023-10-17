package com.example.mylibraryapp.presentation.book.listscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mylibraryapp.R
import com.example.mylibraryapp.domain.model.Book
import com.example.mylibraryapp.presentation.book.common.BookItem
import com.example.mylibraryapp.presentation.book.common.BookItem2
import com.example.mylibraryapp.presentation.common.ItemList
import com.example.mylibraryapp.presentation.common.LabelCount
import com.example.mylibraryapp.presentation.common.SearchBarCard
import com.example.mylibraryapp.presentation.common.TitleLabel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun BookScreen() {
    val viewModel: BookListViewModel = hiltViewModel()
    val books = viewModel.state.value.list
    val isLoading = viewModel.state.value.isLoading

    BookScreenContent(books = books, isLoading = isLoading, modifier = Modifier.fillMaxSize())

}


@Composable
fun BookScreenContent(books: List<Book>, isLoading: Boolean, modifier: Modifier) {


    Box(modifier = modifier) {

        if (isLoading){
            CircularProgressIndicator()
        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.default_screen_padding))
            ) {

                SearchBarCard(
                    modifier = Modifier.fillMaxWidth(),
                    value = "",
                    onValueChange = {""},
                    hint = stringResource(
                        id = R.string.search_book
                    )
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.default_header)))

                TitleLabel(title = stringResource(id = R.string.label_book_list))
                LabelCount(number = books.size)

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.header_half)))


                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(10.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {

                    items(books.size) {
                        BookItem2(books[it])
                    }

                }

            }
        }
        
    }
}
