package com.example.kampusappdemo.module.guest.feature.login.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.module.guest.feature.login.viewmodel.LoginViewModel

@Composable
fun ButtonWithAccountLogin(label: String, icon: Int? = null) {
    OutlinedButton(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp), onClick = { /*TODO*/ }) {
        Box(modifier = Modifier.fillMaxWidth()) {
            if (icon != null) {
                Image(
                    modifier = Modifier.align(Alignment.CenterStart),
                    painter = painterResource(id = icon),
                    contentDescription = ""
                )
            }

            Text(modifier = Modifier.align(Alignment.Center), text = label)
        }
    }
}

@Composable
fun ButtonRegisterLogin(onClick: () -> Unit, viewModel: LoginViewModel) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp),
        enabled = viewModel.isSignUpInstanceConfirmed(),
        onClick = {onClick()}) {
        Text(text = "Register")
    }
}