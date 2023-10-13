package com.example.mylibraryapp.presentation.common

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.mylibraryapp.R

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