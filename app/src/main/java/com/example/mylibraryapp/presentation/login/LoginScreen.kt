package com.example.mylibraryapp.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssuredWorkload
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mylibraryapp.R
import com.example.mylibraryapp.presentation.author.AuthorRegistrationEvent
import com.example.mylibraryapp.presentation.navigation.Destinations

@Composable
fun LoginScreen(navHostController: NavHostController) {

    val viewModel: LoginViewModel = hiltViewModel()

    LoginScreenContent(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(dimensionResource(id = R.dimen.default_screen_padding)),
        loginState = viewModel.state.value,
        handleEvent = viewModel::handleEvent,
        navHostController = navHostController
    )
}

@Composable
fun LoginScreenContent(
    modifier: Modifier,
    loginState: LoginState,
    handleEvent: (event: LoginEvent) -> Unit,
    navHostController: NavHostController
) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        LoginForm(
            loginState,
            navHostController = navHostController,
            onEmailChange = { email -> handleEvent(LoginEvent.EmailChanged(email)) },
            onPasswordChange = { password -> handleEvent(LoginEvent.PasswordChanged(password)) },
            onLogin = { handleEvent(LoginEvent.Login)},
        )
    }

}

@Composable
fun LoginForm(loginState: LoginState, navHostController: NavHostController, onLogin: () -> Unit, onEmailChange: (email: String) -> Unit, onPasswordChange: (password: String) -> Unit) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.default_card_elevation))
    ) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.default_screen_padding))
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            
            LogoAndName()

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.small_spacer)))

            Divider(
                modifier = Modifier
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.tertiary)
            )

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.big_spacer)))

            EmailTextField(loginState = loginState, onEmailChange = onEmailChange)

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.small_spacer)))

            PasswordTextField(loginState = loginState, onPasswordChange = onPasswordChange)

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.medium_spacer)))
            
            LoginButton(loginState = loginState, navHostController = navHostController, onLogin = onLogin)
            
        }
    }
}

@Composable
fun LogoAndName() {
    
    Icon(
        imageVector = Icons.Default.AssuredWorkload,
        contentDescription = stringResource(id = R.string.login_logo),
        modifier = Modifier.size(150.dp)
    )

    Text(
        text = stringResource(id = R.string.company_name),
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold
    )
    
}

@Composable
fun EmailTextField(loginState: LoginState, onEmailChange: (email: String) -> Unit) {

    TextField(
        value = loginState.email,
        onValueChange = { email -> onEmailChange(email) },
        label = { Text(text = stringResource(id = R.string.ft_email)) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = stringResource(id = R.string.email_icon)
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )

}

@Composable
fun PasswordTextField(loginState: LoginState, onPasswordChange: (password: String) -> Unit) {

    var isPasswordHidden by rememberSaveable{mutableStateOf(true)}

    TextField(
        value = loginState.password,
        onValueChange = { password -> onPasswordChange(password) },
        label = { Text(text = stringResource(id = R.string.ft_password)) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        leadingIcon = {
            Icon(imageVector = Icons.Default.Lock, contentDescription = stringResource(id = R.string.password_icon))
        },
        trailingIcon = {
            Icon(imageVector = if (isPasswordHidden) {
                Icons.Default.Visibility
            } else Icons.Default.VisibilityOff,
                modifier = Modifier.clickable {
                    isPasswordHidden = !isPasswordHidden
            }, contentDescription = stringResource(id = R.string.p_visibility_icon)
            )
        },
        visualTransformation = if (isPasswordHidden) {
            PasswordVisualTransformation()
        } else VisualTransformation.None
    )
    
}

@Composable
fun LoginButton(loginState: LoginState, navHostController: NavHostController, onLogin: () -> Unit) {


    Button(
        onClick = {
//            handleEvent(LoginEvent.Login)
            onLogin()
//            val st = loginState.isLoginAllowed
//            if (st) {
//                navHostController.navigate(Destinations.Book.route)
//            }

                  },
        enabled = (loginState.email.isNotEmpty() && loginState.password.isNotEmpty())
    ) {
        Text(text = stringResource(id = R.string.bt_login))
    }


}
