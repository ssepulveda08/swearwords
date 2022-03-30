package com.ssepulveda.swearwords.ui.screens

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ssepulveda.swearwords.viewModels.MainViewModel

@Composable
fun ScreenHome(mainViewModel: MainViewModel = viewModel()) {
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            //Text("Landscape")
            InitFormLandscape(mainViewModel)
        }
        else -> {
            //Text("Portrait")
            InitFormPortrait(mainViewModel)
        }
    }
    AddLoading(mainViewModel)
    InitDialog(mainViewModel)
}

