package com.ssepulveda.swearwords.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ssepulveda.swearwords.ui.theme.SwearWordsTheme
import com.ssepulveda.swearwords.viewModels.MainViewModel

@Composable
fun InitForm(mainViewModel: MainViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        TitleForm("Android")
        SimpleOutlinedTextFieldSample(mainViewModel)
        CustomButton(mainViewModel)
    }
}

@Composable
private fun CustomButton(mainViewModel: MainViewModel = viewModel()) {
    Box(
        contentAlignment = Alignment.BottomCenter
    ) {
        SetupButtonPrimary {
            mainViewModel.onClickButton()
        }
    }
}

@Composable
private fun SimpleOutlinedTextFieldSample(mainViewModel: MainViewModel = viewModel()) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        value = mainViewModel.text,
        onValueChange = {
            mainViewModel.text = it
        },
        label = { Text(
            "Label",
            style = MaterialTheme.typography.overline
        ) }
    )
}

@Composable
private fun TitleForm(name: String) {
    Text(
        modifier = Modifier
            .padding(bottom = 16.dp),
        text = "Hello $name!",
        style = MaterialTheme.typography.h1
    )
}

@Preview(device = Devices.PIXEL_2_XL)
@Composable
private fun DefaultPreview() {
    SwearWordsTheme {
        CustomButton()
    }
}
