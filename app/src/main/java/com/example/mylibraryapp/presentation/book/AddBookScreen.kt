package com.example.mylibraryapp.presentation.book

import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mylibraryapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AddBookScreen() {

    var text by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(10.dp)
    ) {
        Column {


            TextField(
                value = text,
                onValueChange = {text = it},
                label = { Text(text = stringResource(id = R.string.isbn))  },
                modifier = Modifier.fillMaxWidth()
//                keyboardActions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            TextFieldWithText(label = stringResource(id = R.string.title))
            TextFieldWithText2(text, label = stringResource(id = R.string.title))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithText(label: String) {

    var data by rememberSaveable { mutableStateOf("") }

    TextField(
        value = data,
        onValueChange = {data = it},
        label = { Text(text = label)  },
        modifier = Modifier.fillMaxWidth()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithText2(daa: String, label: String) {

    var data by rememberSaveable { mutableStateOf("") }

    TextField(
        value = data,
        onValueChange = {data = it},
        label = { Text(text = label)  },
        modifier = Modifier.fillMaxWidth()
    )
}