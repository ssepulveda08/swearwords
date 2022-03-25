package com.ssepulveda.swearwords.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ssepulveda.swearwords.ui.theme.SwearWordsTheme
import com.ssepulveda.swearwords.viewModels.MainViewModel

@Composable
fun AddLoading(mainViewModel: MainViewModel = viewModel())  {
    AnimatedVisibility(
        visible = mainViewModel.showLoading,
        enter = fadeIn(
            initialAlpha = 0.4f
        ),
        exit = fadeOut(
            animationSpec = tween(durationMillis = 250)
        )
    ) {
        SetupLoading()
    }
}

@Composable
fun SetupLoading() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.3f)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    SwearWordsTheme {
        SetupLoading()
    }
}
