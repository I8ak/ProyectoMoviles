package com.example.proyectomoviles.presentation.ui.screens.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserbanePasswordViewModel : ViewModel(){
    private val _username= MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()
    private val _password= MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()
    fun onUsernameChange(newUsername: String){
        _username.value=newUsername
    }
    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }
    fun reset(){
        _username.value=""
        _password.value=""
    }
    fun isValidLogin(): Boolean {
        return username.value == VALID_USERNAME && password.value == VALID_PASSWORD
    }
}