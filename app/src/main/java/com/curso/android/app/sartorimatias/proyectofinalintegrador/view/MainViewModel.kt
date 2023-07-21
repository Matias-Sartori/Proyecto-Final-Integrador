package com.curso.android.app.sartorimatias.proyectofinalintegrador.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.sartorimatias.proyectofinalintegrador.model.Result
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val result: LiveData<Result> get() = _result
    private var _result = MutableLiveData<Result>(Result("")
    )

    fun compareTexts(text1: String = "", text2: String = "") {
        val textsAreEquals = text1 == text2
        val resultText = if (textsAreEquals) "Ambas cadenas de caracteres son iguales" else "Las cadenas de caracteres no son iguales"
        updateResult(resultText)
    }

    private fun updateResult(res: String) {
        viewModelScope.launch {
            _result.value = Result(res)
        }
    }
}
