package com.example.kampusappdemo.module.guest.feature.login.view.userStudent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.demomarketapp.R
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.module.guest.feature.login.component.BottomBarSignUpLoginDemo
import com.example.kampusappdemo.module.guest.feature.login.component.ButtonWithAccountLogin
import com.example.kampusappdemo.module.guest.feature.login.component.TextFieldLoginDemo
import com.example.kampusappdemo.module.guest.feature.login.component.TextFieldPasswordLoginDemo
import com.example.kampusappdemo.module.guest.feature.login.component.TopBarLoginDemo
import com.example.kampusappdemo.module.guest.feature.login.viewmodel.LoginViewModel
import com.example.kampusappdemo.ui.component.TextTitleDemo

@Composable
fun SignUpStudentScreens(
    navigateUp: () -> Unit,
    navigateSignIn: () -> Unit,
    navigateRegister: (name: String?, phone: String?, email: String?) -> Unit,
    viewModel: LoginViewModel
) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopBarLoginDemo(navigate = { navigateUp() })
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(scrollState)
        ) {
            TextTitleDemo(modifier = Modifier.padding(16.dp), text = "Sign up")
            Spacer(modifier = Modifier.padding(4.dp))
            TextFieldLoginDemo(
                value = viewModel.user,
                onValueChange = { user -> viewModel.updateUser(user) },
                label = "Full name",
                placeholder = "your name",
                keyboardType = KeyboardType.Text,
                trailingIcon = Icons.Default.Person
            )
            TextFieldLoginDemo(
                value = viewModel.phone,
                onValueChange = { phone -> viewModel.updatePhone(phone) },
                label = "Phone",
                placeholder = "+62 1234 5678",
                keyboardType = KeyboardType.Phone,
                trailingIcon = Icons.Default.Phone
            )
            TextFieldLoginDemo(
                value = viewModel.email,
                onValueChange = { email -> viewModel.updateEmail(email) },
                label = "E-mail",
                placeholder = "user@email.com",
                keyboardType = KeyboardType.Email,
                trailingIcon = Icons.Default.Email
            )
            TextFieldPasswordLoginDemo(
                value = viewModel.password,
                onValueChange = { password -> viewModel.updatePassword(password) },
                label = "Insert Password",
                placeholder = "Insert Your Password",
                keyboardType = null
            )
            TextFieldPasswordLoginDemo(
                value = viewModel.confirmPassword,
                onValueChange = { password -> viewModel.updateConfirmPassword(password) },
                label = "Confirm Password",
                placeholder = "Confirm Your Password",
                keyboardType = null
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp),
                onClick = {
                    navigateRegister(viewModel.user, viewModel.phone, viewModel.email)
                    SettingPreferences.typeUser = SettingPreferences.USER
                },
                enabled = viewModel.isSignUpStudentConfirmed()
            ) {
                Text(text = "Register")
            }
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(modifier = Modifier.weight(0.4f))
                Text(modifier = Modifier.padding(horizontal = 16.dp), text = "OR")
                Divider(modifier = Modifier.weight(0.4f))
            }
            ButtonWithAccountLogin(label = "Continue with Google", icon = R.drawable.icongoogle)
            Spacer(modifier = Modifier.padding(4.dp))
            ButtonWithAccountLogin(label = "Continue with Apple", icon = R.drawable.iconapple)
            Spacer(modifier = Modifier.padding(20.dp))
            BottomBarSignUpLoginDemo(navigate = { navigateSignIn() })
        }
    }
}
