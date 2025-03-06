package org.example.project.login


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.project.repository.AuthRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoginViewModel : ViewModel(), KoinComponent {

    private val authRepository: AuthRepository by inject()

    fun login(email: String, password: String, onSuccess: (String) -> Unit, onError: (Throwable) -> Unit) {
        viewModelScope.launch {
            try {
                val response = authRepository.login(email, password)
                onSuccess(response.token)
            } catch (e: Exception) {
                println("e: $e")
                onError(e)
            }
        }
    }
}