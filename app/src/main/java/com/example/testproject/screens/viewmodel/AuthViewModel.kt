package com.example.testproject.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _isButtonEnabled = MutableStateFlow(false)
    val isButtonEnabled: StateFlow<Boolean> = _isButtonEnabled.asStateFlow()

    private var onLoginSuccess: (() -> Unit)? = null

    fun setNavigationCallback(callback: () -> Unit) {
        onLoginSuccess = callback
    }

    fun onEmailChange(newEmail: String) {
        val filteredEmail = newEmail.filter { char ->
            char in 'a'..'z' || char in 'A'..'Z' || char in '0'..'9' ||
                    char == '@' || char == '.' || char == '_' || char == '-'
        }
        _email.value = filteredEmail
        validateForm()
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
        validateForm()
    }

    private fun validateForm() {
        val emailValid = isValidEmail(_email.value)
        val passwordValid = _password.value.isNotEmpty()
        _isButtonEnabled.value = emailValid && passwordValid
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$".toRegex()
        return email.matches(emailRegex)
    }

    fun login() {
        viewModelScope.launch {
            onLoginSuccess?.invoke()
        }
    }
}