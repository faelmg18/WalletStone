package br.com.rafaelhfernandes.core.presentation.transactions

import androidx.lifecycle.*
import br.com.rafaelhfernandes.core.domain.entities.Wallet
import br.com.rafaelhfernandes.core.framework.RepositoryFactory
import br.com.rafaelhfernandes.core.presentation.BaseViewModel
import br.com.rafaelhfernandes.core.presentation.UiState
import br.com.rafaelhfernandes.core.presentation.app.WalletStoneApplication
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel : BaseViewModel() {

    private val walletRepository = RepositoryFactory
        .getInstance(WalletStoneApplication.appContext)
        .creatWalletRepositories()

    private val loginLogoutManager = RepositoryFactory
        .getInstance(WalletStoneApplication.appContext)
        .createLoginLogoutManagerRepositories()

    class Factory @Inject constructor(

    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel() as T
            }
            throw IllegalArgumentException("ViewModel not found")
        }
    }

    private val _walletLiveData = MutableLiveData<Wallet>()
    val walletLiveData: LiveData<Wallet> = _walletLiveData

    fun getBalance() {
        updateUiState(UiState.Loading)
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            postError(throwable)
        }) {

            val userId = loginLogoutManager.retrieveUserLogged()?.id

            userId?.let {
                val wallet = walletRepository.retrieveBalance(it)
                _walletLiveData.postValue(wallet)
                updateUiState(UiState.Complete)
            }
        }
    }
}