package com.example.mylibraryapp.presentation.author.listscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mylibraryapp.R
import com.example.mylibraryapp.domain.model.Author
import com.example.mylibraryapp.presentation.common.ItemList
import com.example.mylibraryapp.presentation.common.LabelCount
import com.example.mylibraryapp.presentation.common.SearchBarCard
import com.example.mylibraryapp.presentation.common.TitleLabel

@Preview
@Composable
fun NewAuthorScreen() {

    val viewModel: AuthorListViewModel = hiltViewModel()
    val authorList = viewModel.state.value
    val isLoading = viewModel.state.value.isLoading

    AuthorScreenContent(

        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        authorList = authorList.list
//        authorList = listOf(Author(null, "Juan Ramirez"), Author(null, "pepe perez"))
    , isLoading = isLoading
    )

}

@Composable
fun AuthorScreenContent(modifier: Modifier, authorList: List<Author>, isLoading: Boolean) {

    Box(modifier = modifier) {

//        if (isLoading) {
//            CircularProgressIndicator()
//        } else {
//
//        }
        Column(
            modifier = Modifier
//                .background(Color.Red)
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.default_screen_padding))
        ) {

            SearchBarCard(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {""},
                hint = stringResource(
                    id = R.string.search_author
                )
            )

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.default_header)))

            TitleLabel(title = stringResource(id = R.string.label_author_list))
            LabelCount(number = authorList.size)

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.header_half)))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(authorList.size) {
//                    val author = authorList[it]
                    ItemList(
                        modifier = modifier,
                        author = authorList[it],
                        onClick = { println("id: ${authorList[it].id}, name: ${authorList[it].name}") }
                    )
                }
            }



        }

    }
}