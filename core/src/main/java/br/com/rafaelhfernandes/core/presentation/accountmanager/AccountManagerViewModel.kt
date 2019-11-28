package br.com.rafaelhfernandes.core.presentation.accountmanager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.rafaelhfernandes.core.presentation.BaseViewModel
import javax.inject.Inject


class AccountManagerViewModel @Inject constructor() : BaseViewModel() {

    override fun myOnCleared() {

    }

    class Factory @Inject constructor(

    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AccountManagerViewModel::class.java)) {
                return AccountManagerViewModel() as T
            }
            throw IllegalArgumentException("ViewModel not found")
        }
    }

}