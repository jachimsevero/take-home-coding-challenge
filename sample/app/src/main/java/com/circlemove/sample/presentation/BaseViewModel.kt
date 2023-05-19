package com.circlemove.sample.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    var showDialog by mutableStateOf(false)

    fun showErrorDialog() {
        showDialog = true
    }

    fun onDismissDialog() {
        showDialog = false
    }
}