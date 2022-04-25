package com.ssepulveda.swearwords.ui.screens

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun OrientationView(
    composableLandscape: @Composable () -> Unit,
    composablePortrait: @Composable () -> Unit
) {
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            composableLandscape()
        }
        else -> {
            composablePortrait()
        }
    }
}