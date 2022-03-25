package com.ssepulveda.swearwords.ui.activitys

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.ssepulveda.swearwords.ui.screens.AddLoading
import com.ssepulveda.swearwords.ui.screens.InitDialog
import com.ssepulveda.swearwords.ui.screens.InitForm
import com.ssepulveda.swearwords.ui.theme.SwearWordsTheme
import com.ssepulveda.swearwords.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwearWordsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ContainerSnackBar {
                        InitForm(viewModel)
                        AddLoading(viewModel)
                        InitDialog(viewModel)
                    }
                }
            }
        }
    }

    @Composable
    private fun ContainerSnackBar(content: @Composable () -> Unit) {
        val coroutineScope = rememberCoroutineScope()
        val scaffoldState = rememberScaffoldState()

        val onShowSnackBar: (String) -> Unit = { task ->
            coroutineScope.launch {
                val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = task,
                    actionLabel = "OK",
                )
                when (snackBarResult) {
                    SnackbarResult.Dismissed -> {
                        viewModel.hideSnackBar()
                    }
                    SnackbarResult.ActionPerformed -> {
                        viewModel.hideSnackBar()
                    }
                }
            }
        }
        if (!viewModel.uiSnackBar.isNullOrBlank()){
            onShowSnackBar.invoke(
                viewModel.uiSnackBar.orEmpty()
            )
        }
        Scaffold(scaffoldState = scaffoldState) {
            content()
        }
    }
}
