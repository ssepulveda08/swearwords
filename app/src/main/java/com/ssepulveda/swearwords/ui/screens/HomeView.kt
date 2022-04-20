package com.ssepulveda.swearwords.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ssepulveda.swearwords.viewModels.MainViewModel

@Composable
fun ScreenHome(mainViewModel: MainViewModel = viewModel()) {
    OrientationView(
        composableLandscape = { InitFormLandscape(mainViewModel) },
        composablePortrait = { InitFormPortrait(mainViewModel) }
    )
    AddLoading(mainViewModel)
    InitDialog(mainViewModel)
}

