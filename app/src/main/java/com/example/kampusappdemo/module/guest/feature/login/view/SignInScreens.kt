package com.example.kampusappdemo.module.guest.feature.login.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import com.example.kampusappdemo.data.datastore.UserData
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.demomarketapp.R
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.module.guest.feature.login.component.BottomBarSignInLoginDemo
import com.example.kampusappdemo.module.guest.feature.login.component.ButtonWithAccountLogin
import com.example.kampusappdemo.module.guest.feature.login.component.TextFieldLoginDemo
import com.example.kampusappdemo.module.guest.feature.login.component.TextFieldPasswordLoginDemo
import com.example.kampusappdemo.module.guest.feature.login.component.TopBarLoginDemo
import com.example.kampusappdemo.module.guest.feature.login.component.TopBarSignInLoginDemo
import com.example.kampusappdemo.module.guest.feature.login.viewmodel.LoginViewModel
import com.example.kampusappdemo.ui.component.TextSubHeadlineDemo
import com.example.kampusappdemo.ui.component.TextTitleDemo
import kotlinx.coroutines.launch

@Composable
fun SignIn(
    navigateUp: () -> Unit,
    navigateSignUp: () -> Unit,
    navigateHome: () -> Unit,
    viewModel: LoginViewModel
) {
    val context = LocalContext.current

    val dataStore = UserData(context)

    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopBarSignInLoginDemo(navigate = { navigateUp() })
        },
        bottomBar = {
            BottomBarSignInLoginDemo(openDialog = { navigateSignUp() })
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            TextTitleDemo(modifier = Modifier.padding(16.dp), text = "Sign in")
            TextFieldLoginDemo(
                value = viewModel.email,
                onValueChange = { email -> viewModel.updateEmail(email) },
                label = "E-mail",
                placeholder = "user@email.com",
                keyboardType = KeyboardType.Email,
            )
            TextFieldPasswordLoginDemo(
                value = viewModel.password,
                onValueChange = { password -> viewModel.updatePassword(password) },
                label = "Insert Password",
                placeholder = "Insert Your Password",
                keyboardType = null
            )
            TextButton(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .align(Alignment.End),
                onClick = { /*TODO*/ }) {
                Text(text = "Forgot Password?")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp),
                enabled = viewModel.isSignInConfirmed(),
                onClick = { navigateHome() }) {
                Text(text = "Login")
            }
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(modifier = Modifier.weight(0.4f))
                Text(modifier = Modifier.padding(horizontal = 16.dp), text = "OR")
                HorizontalDivider(modifier = Modifier.weight(0.4f))
            }
            ButtonWithAccountLogin(
                label = "Continue with Google",
                icon = R.drawable.icongoogle,
                onClick = {})
            Spacer(modifier = Modifier.padding(4.dp))
            ButtonWithAccountLogin(
                label = "Continue with Apple",
                icon = R.drawable.iconapple,
                onClick = {})
            Spacer(modifier = Modifier.padding(4.dp))
            ButtonWithAccountLogin(label = "Continue as Guest", onClick = {
                navigateHome()
                SettingPreferences.typeUser = SettingPreferences.GUEST
                scope.launch {
                    dataStore.saveUserName("Guest")
                }
            })
        }
    }
}
