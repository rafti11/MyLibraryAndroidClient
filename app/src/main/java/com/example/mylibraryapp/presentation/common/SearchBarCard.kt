package com.example.mylibraryapp.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mylibraryapp.R
import com.example.mylibraryapp.domain.model.Book
import com.example.mylibraryapp.domain.model.Loan
import com.example.mylibraryapp.presentation.book.common.BookImage
import java.util.ArrayList
import java.util.Objects

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarCard(modifier: Modifier, value: String, onValueChange: (value: String) -> Unit, hint: String) {

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            dimensionResource(id = R.dimen.default_card_elevation)
        )
    ) {
        TextField(
            modifier = modifier,
            value = value,
            onValueChange = { value -> onValueChange(value) },
            placeholder = {
                Text(text = hint)
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = null)
            },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            )
        )
        
//        Text(text = hint, modifier = modifier)
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarCustom(hint: String, list: List<Any>) {

    var query by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    SearchBar(
        query = query,
        onQueryChange = {query = it},
        onSearch = {active = false},
        active = active,
        onActiveChange = {active = it},
        placeholder = {
            Text(text = hint)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = R.string.search_icon)
            )
        },
        trailingIcon = {
            if (active) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(id = R.string.close_icon),
                    modifier = Modifier.clickable {

                        if (query.isNotEmpty()) {
                            query = ""
                        } else {
                            active = false
                        }
                    }
                )
            }
        }
    ) {

        if (query.isNotEmpty()) {
            val books = ArrayList<Book>()
            val loans = ArrayList<Loan>()

            list.forEach { data ->
                if (data is Book) {
                    books.add(data)
                }
                if (data is Loan) {
                    loans.add(data)
                }
            }

            if (books.isNotEmpty()) {

                val filterBooks = books.filter {
                    it.title.lowercase().contains(query.lowercase())
                }

                filterBooks.forEach {
                    DataBookRow(book = it)
                }
            }

            if (loans.isNotEmpty()) {

                val filterLoans = loans.filter {
                    it.bookTitle.contains(query)
                }

                filterLoans.forEach {
                    DataLoanRow(loan = it)
                }
            }


        }

    }

}

@Composable
fun DataBookRow(book: Book) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        AsyncImage(
            model = "http://10.10.2.9/images/${book.isbn}.jpg",
            contentDescription = "Book cover",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .background(Color.White)
                .height(60.dp)
//            .width(140.dp)
        )
        Text(
            text = book.title,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.item_start_padding)
            )
        )
    }
}

@Composable
fun DataLoanRow(loan: Loan) {
    Row() {
        Text(text = loan.bookTitle)
    }
}
