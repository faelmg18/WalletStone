package br.com.rafaelhfernandes.core.presentation.price

import android.util.Log
import androidx.lifecycle.*
import br.com.rafaelhfernandes.core.data.price.PriceDataSource
import br.com.rafaelhfernandes.core.domain.entities.Price
import br.com.rafaelhfernandes.core.domain.usecases.GetDollarPrice
import br.com.rafaelhfernandes.core.framework.RepositoryFactory
import br.com.rafaelhfernandes.core.framework.model.BaseResponse
import br.com.rafaelhfernandes.core.presentation.UiState
import br.com.rafaelhfernandes.core.presentation.app.WalletStoneApplication
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

class PriceViewModel @Inject constructor(
    getDollarPrice: GetDollarPrice
) : ViewModel() {

    val priceRepository =
        RepositoryFactory.getInstance(WalletStoneApplication.appContext).createPriceRepositories()

    class Factory @Inject constructor(
        private val getDollarPrice: GetDollarPrice

    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PriceViewModel::class.java)) {
                return PriceViewModel(getDollarPrice) as T
            }
            throw IllegalArgumentException("ViewModel not found")
        }
    }

    private val _price = MutableLiveData<BaseResponse<Price>>()
    val priceObservable: LiveData<BaseResponse<Price>> = _price

    private val _getPriceState = MutableLiveData<UiState>()
    val getPriceState: LiveData<UiState> = _getPriceState

    init {
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            _getPriceState.postValue(UiState.Error(throwable))
        }) {
            _getPriceState.postValue(UiState.Loading)
            val prices = getDollarPrice()

            prices.results.forEach {
               priceRepository.save(it)
            }

            _price.postValue(prices)
            _getPriceState.postValue(UiState.Complete)
        }
    }

}