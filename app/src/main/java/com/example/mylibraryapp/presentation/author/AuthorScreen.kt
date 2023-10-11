package com.example.mylibraryapp.presentation.author

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mylibraryapp.R
import com.example.mylibraryapp.presentation.author.components.AuthorEntryItem

@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun AuthorScreen() {

    var text by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .padding(10.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)) {
            Image(
                painter = painterResource(id = R.drawable.person_25dp),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                alignment = Alignment.Center
            )

            TextField(
                value = text,
                onValueChange = {text = it},
                label = { Text(text = stringResource(id = R.string.label_name)) },
                modifier = Modifier.fillMaxWidth()
            )

            Button(onClick = { /*TODO*/ }) {
                
            }

            LazyColumn(
                modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
            ) {
                items(30) {
                    AuthorEntryItem()
                }
            }
        }
    }
}

@Preview
@Composable
fun AuthorScreen2() {

    val viewModel: AuthorRegistrationViewModel = viewModel()

    AuthorScreenContent(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        authorRegistrationState = viewModel.state.value,
        handleEvent = viewModel::handleEvent)
}

//@Preview
@Composable
fun AuthorScreenContent(
    modifier: Modifier = Modifier,
    authorRegistrationState: AuthorRegistrationState,
    handleEvent: (event: AuthorRegistrationEvent) -> Unit
) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        if (authorRegistrationState.isLoading) {
            CircularProgressIndicator()
        } else {

            AuthorForm(
                modifier = modifier,
                name= authorRegistrationState.name,
                onNameChanged = { name ->  handleEvent(AuthorRegistrationEvent.NameChanged(name))},
                onSubmit = {handleEvent(AuthorRegistrationEvent.Submit)}
            )
        }
    }
}

@Composable
fun AuthorForm(
    modifier: Modifier = Modifier,
    name: String?,
    onNameChanged: (name: String) -> Unit,
    onSubmit: () -> Unit
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(25.dp))
        AuthorFormTitleIcon()
        Spacer(modifier = Modifier.height(5.dp))
        AuthorFormTitle(modifier)
        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            elevation = CardDefaults.cardElevation(3.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                NameInput(
                    modifier = Modifier.fillMaxWidth(),
                    name = name ?: "",
                    onNameChanged = { name ->  onNameChanged(name) }
                )

                Spacer(modifier = Modifier.height(25.dp))

                RegisterButton(onSubmit = onSubmit)

            }
        }


    }
}


@Composable
fun AuthorFormTitle(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.label_author_screen_header),
        fontSize = 24.sp,
        fontWeight = FontWeight.Black
    )
}

@Composable
fun AuthorFormTitleIcon(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.person_25dp),
        contentDescription = null
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameInput(modifier: Modifier = Modifier, name: String, onNameChanged: (name: String) -> Unit) {
    TextField(
        modifier = modifier,
        value = name,
        onValueChange = { email -> onNameChanged(email) },
        label = {
            Text(text = stringResource(id = R.string.label_input_author_name))
        },
        singleLine = true
    )
}

@Composable
fun RegisterButton(
    modifier: Modifier = Modifier,
    onSubmit: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = {
            onSubmit()
        }
    ) {
        Text(
            text = stringResource(id = R.string.label_button_submit)
        )
        
    }
}