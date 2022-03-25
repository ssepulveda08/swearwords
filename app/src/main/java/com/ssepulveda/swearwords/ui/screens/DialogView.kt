package com.ssepulveda.swearwords.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ssepulveda.swearwords.R
import com.ssepulveda.swearwords.ui.theme.SwearWordsTheme
import com.ssepulveda.swearwords.viewModels.MainViewModel

@Composable
fun InitDialog(mainViewModel: MainViewModel = viewModel()) {
    if (!mainViewModel.uiDialog.onDialogError.isNullOrBlank()) {
        ErrorDialog(
            mainViewModel.uiDialog.onDialogError.orEmpty(),
            {
                mainViewModel.onCloseDialog()
            }, {
                mainViewModel.onClearTextDismissDialog()
            }
        )
    }
    if (mainViewModel.uiDialog.onDialogSuccess) {
        SuccessDialog {
            mainViewModel.onCloseDialog()
        }
    }
}

@Composable
fun SuccessDialog(
    onDismissRequestAction: () -> Unit = {}
) {
    Dialog(onDismissRequest = onDismissRequestAction) {
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(12.dp)
        ) {
            Column {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .background(Color.Green)
                        .height(160.dp)
                ) {
                    LottieGood()
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "¡Bien hecho!",
                        style = MaterialTheme.typography.h1

                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Este texto no tiene palabrotas",
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 12.dp
                        )
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(onClick = onDismissRequestAction) {
                        Text(
                            text = "OK",
                            style = MaterialTheme.typography.button
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ErrorDialog(
    message: String,
    onDismissRequestAction: () -> Unit = {},
    onClearAction: () -> Unit = {}
) {
    Dialog(onDismissRequest = onDismissRequestAction) {
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(12.dp)
        ) {
            Column {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .background(Color.Red)
                        .height(160.dp)
                ) {
                    LottieError()
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "¡Oops!",
                        style = MaterialTheme.typography.h1,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Lo sentimos!, Este texto tiene palabrotas :( ",
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 12.dp
                        )
                    )
                    Text(
                        text = message,
                        style = MaterialTheme.typography.caption,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 12.dp,
                            bottom = 12.dp
                        )
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(onClick = onClearAction) {
                        Text(
                            text = "Limpiar",
                            style = MaterialTheme.typography.button,
                        )
                    }

                    TextButton(onClick = onDismissRequestAction) {
                        Text(
                            text = "OK",
                            style = MaterialTheme.typography.button,
                        )
                    }
                }
            }
        }
    }
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


@Preview(showBackground = false)
@Composable
private fun DefaultDialogSuccess() {
    SwearWordsTheme {
        SuccessDialog()
    }
}

@Preview(showBackground = false)
@Composable
private fun DefaultDialogError() {
    SwearWordsTheme {
        ErrorDialog("Message tes")
    }
}
