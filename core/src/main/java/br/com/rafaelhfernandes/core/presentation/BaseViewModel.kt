package br.com.rafaelhfernandes.core.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable


abstract class BaseViewModel : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiSate: LiveData<UiState> = _uiState

    fun postError(throwable: Throwable) {
        _uiState.postValue(UiState.Error(throwable))
    }

    fun updateUiState(uiState: UiState) {
        _uiState.postValue(uiState)
    }
}