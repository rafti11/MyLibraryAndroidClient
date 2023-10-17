package com.example.mylibraryapp.presentation.book.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mylibraryapp.R
import com.example.mylibraryapp.domain.model.Book

@Preview
@Composable
fun BookItem() {

    Card(

    ) {

        Column {
            BookImage(image = "http://10.10.2.9/images/9780349437002.jpg")
//            BookImageTest()
            BookTitle(title = "Las cosas de casa")
            BookAuthor(name = "Manolito")
        }

    }
}

@Composable
fun BookItem2(book: Book) {

    Card(

    ) {

        Column {
            BookImage(image = "http://10.10.2.9/images/${book.isbn}.jpg")
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
            .fillMaxSize()
//            .width(140.dp)
    )
}

@Composable
fun BookTitle(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = dimensionResource(id = R.dimen.item_start_padding))
    )
}

@Composable
fun BookAuthor(name: String) {
    Text(
        text = name,
        fontSize = 20.sp,
//        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = dimensionResource(id = R.dimen.item_start_padding))
    )
}

@Preview
@Composable
fun TestGrid() {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        items(30) {
            BookItem()
        }

    }
}