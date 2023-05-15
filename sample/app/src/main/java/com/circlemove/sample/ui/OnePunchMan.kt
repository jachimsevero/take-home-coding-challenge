package com.circlemove.sample.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.circlemove.sample.vm.OnePunchManViewModel

@Composable
fun OnePunchMan() {
    val viewModel: OnePunchManViewModel = hiltViewModel()
    val model by viewModel.modelFlow.collectAsState()

    Text(text = model.fare)
}