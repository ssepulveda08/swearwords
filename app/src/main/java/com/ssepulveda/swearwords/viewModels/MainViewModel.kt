package com.ssepulveda.swearwords.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssepulveda.swearwords.data.ApiDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataSource: ApiDataSource,
) : ViewModel() {

    var text by mutableStateOf("")

    var showLoading by mutableStateOf(false)

    var uiDialog by mutableStateOf(UiSateDialog())

    var uiSnackBar by mutableStateOf<String?>(null)

    private var job: Job? = null

    fun onClickButton() {
        viewModelScope.launch {
            showLoading = true
            validateFields()
        }
    }
    private fun validateFields() {
        if (text.isBlank()) {
            uiSnackBar = "Ingresa un texto para poderlo validar"
            showLoading = false
        } else {
            isTextContainsProfanity()
        }
    }

    private fun isTextContainsProfanity() {
        job?.cancelChildren()
        job = viewModelScope.launch {
            dataSource.isContainsProfanity(text).let {
                if (it.isSuccessful){
                    if (it.body() == true) {
                        getResultJson()?.let { response ->
                            uiDialog = UiSateDialog(
                                onDialogError = response
                            )
                        }
                    } else {
                        uiDialog = UiSateDialog(
                            onDialogSuccess = true
                        )
                    }
                }
            }
            delay(200)
            showLoading = false
        }
    }

    private suspend fun getResultJson() : String? {
        dataSource.getResultJson(text).let {
            if (it.isSuccessful){
                return it.body()?.result
            } else {
                return null
            }
        }
    }

    fun onCloseDialog() {
        uiDialog = UiSateDialog()
    }

    fun onClearTextDismissDialog() {
        text = ""
        uiDialog = UiSateDialog()
    }

    fun hideSnackBar() {
        uiSnackBar = null
    }
}

data class UiSateDialog(
    val onDialogError: String? = null,
    val onDialogSuccess: Boolean = false
)
