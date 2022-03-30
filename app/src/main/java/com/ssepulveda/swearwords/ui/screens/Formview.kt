package com.ssepulveda.swearwords.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ssepulveda.swearwords.ui.theme.SwearWordsTheme
import com.ssepulveda.swearwords.viewModels.MainViewModel

@Composable
fun InitFormLandscape(mainViewModel: MainViewModel = viewModel()) {
    Row {
        SimpleOutlinedTextFieldSample(
            Modifier.fillMaxHeight().weight(0.6f).padding(16.dp),
            mainViewModel
        )
        Column(
            modifier = Modifier.fillMaxHeight().weight(0.4f).padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TitleForm()
            CustomButton(mainViewModel)
        }
    }
}

@Composable
fun InitFormPortrait(mainViewModel: MainViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        TitleForm()
        SimpleOutlinedTextFieldSample(mainViewModel = mainViewModel)
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
private fun SimpleOutlinedTextFieldSample(
    customModifier: Modifier = getDefaultModifierTextField(),
    mainViewModel: MainViewModel = viewModel()
) {
    OutlinedTextField(
        modifier = customModifier,
        value = mainViewModel.text,
        textStyle = MaterialTheme.typography.body2,
        onValueChange = {
            mainViewModel.text = it
        },
        label = { Text(
            "Label",
            style = MaterialTheme.typography.overline
        ) }
    )
}

private fun getDefaultModifierTextField() = Modifier
.fillMaxWidth()
.height(200.dp)

@Composable
private fun TitleForm() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp,),
            text = "Hola!",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1
        )
        Text(
            modifier = Modifier
                .padding(
                    top = 10.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                ),
            text = "Estamos a gusto de validar tu texto, te diremos si tiene Palabrotas",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview(device = Devices.PIXEL_2_XL)
@Composable
private fun DefaultPreview() {
    SwearWordsTheme {
        CustomButton()
    }
}
