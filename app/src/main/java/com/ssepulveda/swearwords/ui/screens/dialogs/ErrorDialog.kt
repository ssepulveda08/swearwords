package com.ssepulveda.swearwords.ui.screens.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ssepulveda.swearwords.ui.screens.LottieError
import com.ssepulveda.swearwords.ui.screens.OrientationView

@Composable
fun ErrorDialog(
    message: String,
    onDismissRequestAction: () -> Unit = {},
    onClearAction: () -> Unit = {}
) {
    Dialog(
        onDismissRequest = onDismissRequestAction,
    ) {

        OrientationView(
            composableLandscape = {
                ErrorDialogLandscape(
                    message,
                    onClearAction,
                    onDismissRequestAction
                )
            },
            composablePortrait = {
                ErrorDialogPortrait(
                    message,
                    onClearAction,
                    onDismissRequestAction
                )
            }
        )
    }
}

@Composable
private fun ErrorDialogLandscape(
    message: String,
    onClearAction: () -> Unit,
    onDismissRequestAction: () -> Unit
) {
    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.85f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ErrorDialogAnimation(ModifierDialogError.ANIMATION_LANDSCAPE.modifier)
                InformationText(message, ModifierDialogError.INFORMATION_LANDSCAPE.modifier)
            }
            keypadDialog(
                Modifier
                    .fillMaxHeight()
                    .align(Alignment.End)
                    .weight(0.15f),
                onClearAction,
                onDismissRequestAction
            )
        }
    }
}

@Composable
private fun ErrorDialogPortrait(
    message: String,
    onClearAction: () -> Unit,
    onDismissRequestAction: () -> Unit
) {
    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column {
            ErrorDialogAnimation(ModifierDialogError.ANIMATION_PORTRAIT.modifier)
            InformationText(message, ModifierDialogError.INFORMATION_PORTRAIT.modifier)
            keypadDialog(
                ModifierDialogError.KEYPAD_PORTRAIT.modifier,
                onClearAction,
                onDismissRequestAction
            )
        }
    }
}

@Composable
private fun ErrorDialogAnimation(customModifier: Modifier) {
    Box(modifier = customModifier) {
        LottieError()
    }
}

@Composable
private fun keypadDialog(
    customModifier: Modifier,
    onClearAction: () -> Unit,
    onDismissRequestAction: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = customModifier
    ) {
        ButtonText("Limpiar", onClearAction)
        ButtonText("OK", onDismissRequestAction)
    }
}

@Composable
private fun ButtonText(text: String, action: () -> Unit) {
    TextButton(onClick = action) {
        Text(
            text = text,
            style = MaterialTheme.typography.button,
        )
    }
}

@Composable
private fun InformationText(message: String, CustomModifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = CustomModifier
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
}

enum class ModifierDialogError(val modifier: Modifier) {
    ANIMATION_PORTRAIT(
        Modifier
            .fillMaxWidth()
            .background(Color.Red)
            .height(160.dp)
    ),
    INFORMATION_PORTRAIT(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ),
    KEYPAD_PORTRAIT(
        Modifier.fillMaxWidth()
    ),
    ANIMATION_LANDSCAPE(
        Modifier
            .padding(top = 12.dp)
            .size(90.dp)
            .clip(CircleShape)
            .background(Color.Red)
    ),
    INFORMATION_LANDSCAPE(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(PaddingValues(16.dp, 12.dp, 16.dp, 4.dp))
    )
}
