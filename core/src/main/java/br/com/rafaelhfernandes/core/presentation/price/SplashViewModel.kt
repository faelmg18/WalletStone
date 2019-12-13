package br.com.rafaelhfernandes.core.presentation.price

import androidx.lifecycle.*
import br.com.rafaelhfernandes.core.domain.usecases.GetBritaPrice
import br.com.rafaelhfernandes.core.framework.RepositoryFactory
import br.com.rafaelhfernandes.core.presentation.UiState
import br.com.rafaelhfernandes.core.presentation.accountmanager.AccountManagerFeatureRouter
import br.com.rafaelhfernandes.core.presentation.app.WalletStoneApplication
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    val getBritaPrice: GetBritaPrice
) : ViewModel() {

    val britaRepository =
        RepositoryFactory.getInstance(WalletStoneApplication.appContext).createBritaRepositories()

    val loginLogoutManager =
        RepositoryFactory.getInstance(WalletStoneApplication.appContext).createLoginLogoutManagerRepositories()

    class Factory @Inject constructor(
        private val getBritaPrice: GetBritaPrice

    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
                return SplashViewModel(getBritaPrice) as T
            }
            throw IllegalArgumentException("ViewModel not found")
        }
    }

    private val _price = MutableLiveData<AccountManagerFeatureRouter>()
    val priceObservable: LiveData<AccountManagerFeatureRouter> = _price

    private val _getPriceState = MutableLiveData<UiState>()
    val getPriceState: LiveData<UiState> = _getPriceState

    fun getDollarPriceToday(){
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            _getPriceState.postValue(UiState.Error(throwable))
        }) {
            _getPriceState.postValue(UiState.Loading)
            val prices = getBritaPrice.invoke()

            val userLogged = loginLogoutManager.retrieveUserLogged()

            var state = AccountManagerFeatureRouter.GOTO_SIGIN_FEATURE

            userLogged?.let {
                state = AccountManagerFeatureRouter.GOTO_LIST_PUSHED
            }

            prices.results.forEach {
                britaRepository.save(it)
            }
            _price.postValue(state)
            _getPriceState.postValue(UiState.Complete)
        }
    }
}