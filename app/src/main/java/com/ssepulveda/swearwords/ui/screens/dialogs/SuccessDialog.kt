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
import com.ssepulveda.swearwords.ui.screens.LottieGood
import com.ssepulveda.swearwords.ui.screens.OrientationView

@Composable
fun SuccessDialog(
    onDismissRequestAction: () -> Unit = {}
) {
    Dialog(onDismissRequest = onDismissRequestAction) {
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(12.dp)
        ) {
            OrientationView(
                composableLandscape = {
                    SuccessDialogLandscape(onDismissRequestAction)
                },
                composablePortrait = {
                    SuccessDialogPortrait(onDismissRequestAction)
                }
            )
        }
    }
}

@Composable
private fun SuccessDialogPortrait(onDismissRequestAction: () -> Unit) {
    Column {
        DialogAnimationSuccess(ModifierDialogSuccess.ANIMATION_PORTRAIT.modifier)
        TextInformation()
        KeyPadDialog(onDismissRequestAction)
    }
}

@Composable
private fun SuccessDialogLandscape(onDismissRequestAction: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        DialogAnimationSuccess(ModifierDialogSuccess.ANIMATION_LANDSCAPE.modifier)
        TextInformation()
        KeyPadDialog(onDismissRequestAction)
    }
}

@Composable
private fun TextInformation() {
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
}

@Composable
private fun KeyPadDialog(onDismissRequestAction: () -> Unit) {
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

@Composable
private fun DialogAnimationSuccess(customModifier: Modifier) {
    Box(
        modifier = customModifier
    ) {
        LottieGood()
    }
}

enum class ModifierDialogSuccess(val modifier: Modifier) {
    ANIMATION_PORTRAIT(
        Modifier
            .fillMaxWidth()
            .background(Color.Green)
            .height(160.dp)
    ),
    ANIMATION_LANDSCAPE(
        Modifier
            .padding(top = 12.dp)
            .size(90.dp)
            .clip(CircleShape)
            .background(Color.Green)
    )
}
