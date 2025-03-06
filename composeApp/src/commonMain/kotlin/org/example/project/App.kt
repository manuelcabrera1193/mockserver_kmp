package org.example.project

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.example.project.login.LoginScreen
import org.example.project.login.LoginViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        val viewModel = LoginViewModel()
        LoginScreen(viewModel)
    }
}