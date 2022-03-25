package com.ssepulveda.swearwords.ui.screens

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun CustomToolbar(action: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Swear Words",
                style = MaterialTheme.typography.overline
            )
        },
        actions = {
            IconButton(onClick = action) {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = "option")
            }
        },
        elevation = 2.dp
    )
}