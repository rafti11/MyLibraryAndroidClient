package com.example.mylibraryapp.presentation.book.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mylibraryapp.R
import com.example.mylibraryapp.common.Tags
import com.example.mylibraryapp.domain.model.Book

@Composable
fun BookItem(book: Book) {

    Card {

        Column {
            BookImage(image = "${Tags.IMAGEN_URL}${book.isbn}.jpg")
//            BookImageTest()
            BookTitle(title = book.title)
            BookAuthor(name = "Manolito${book.author}")
        }

    }
}

@Composable
fun BookImageTest() {
    Box(modifier = Modifier
        .height(200.dp)
        .width(140.dp)
        .background(Color.Red))
}

@Composable
fun BookImage(image: String) {
    AsyncImage(
        model = image,
        contentDescription = "Book cover",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .background(Color.White)
            .height(250.dp)
    )
}

@Composable
fun BookTitle(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .padding(start = dimensionResource(id = R.dimen.item_start_padding))
    )
}

@Composable
fun BookAuthor(name: String) {
    Text(
        text = name,
        fontSize = 20.sp,
        modifier = Modifier
            .padding(start = dimensionResource(id = R.dimen.item_start_padding))
    )
}
