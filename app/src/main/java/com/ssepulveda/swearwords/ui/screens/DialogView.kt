package com.ssepulveda.swearwords.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ssepulveda.swearwords.ui.screens.dialogs.ErrorDialog
import com.ssepulveda.swearwords.ui.screens.dialogs.SuccessDialog
import com.ssepulveda.swearwords.ui.theme.SwearWordsTheme
import com.ssepulveda.swearwords.viewModels.MainViewModel

@Composable
fun InitDialog(mainViewModel: MainViewModel = viewModel()) {
    if (!mainViewModel.uiDialog.onDialogError.isNullOrBlank()) {
        ErrorDialog(
            message = mainViewModel.uiDialog.onDialogError.orEmpty(),
            onDismissRequestAction = mainViewModel::onCloseDialog,
            onClearAction = mainViewModel::onClearTextDismissDialog
        )
    }
    if (mainViewModel.uiDialog.onDialogSuccess) {
        SuccessDialog {
            mainViewModel.onCloseDialog()
        }
    }
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
