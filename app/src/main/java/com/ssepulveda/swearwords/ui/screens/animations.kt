package com.ssepulveda.swearwords.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.*
import com.ssepulveda.swearwords.R

@Composable
fun LottieError() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.fail))
    val progress by animateLottieCompositionAsState(
        composition,
        clipSpec = LottieClipSpec.Progress(0.0f, 0.48f),
    )
    LottieAnimation(
        composition,
        progress,
        modifier = Modifier.fillMaxSize(),
    )
}

@Composable
fun LottieGood() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.good))
    val progress by animateLottieCompositionAsState(
        composition,
        clipSpec = LottieClipSpec.Progress(0.0f, 0.7f)
    )
    LottieAnimation(
        composition,
        progress,
        modifier = Modifier.fillMaxSize(),
    )
}
