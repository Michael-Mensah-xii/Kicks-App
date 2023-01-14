package com.example.trainersapp.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var firstname by mutableStateOf("")
    var lastname by mutableStateOf("")
    var phone by mutableStateOf("")
    var paswword by mutableStateOf("")
}