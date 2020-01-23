package br.com.rafaelhfernandes.core.presentation.accountmanager

import androidx.lifecycle.*
import br.com.rafaelhfernandes.core.domain.entities.LoginLogoutManager
import br.com.rafaelhfernandes.core.domain.entities.User
import br.com.rafaelhfernandes.core.domain.entities.Wallet
import br.com.rafaelhfernandes.core.framework.RepositoryFactory
import br.com.rafaelhfernandes.core.presentation.BaseViewModel
import br.com.rafaelhfernandes.core.presentation.UiState
import br.com.rafaelhfernandes.core.presentation.app.WalletStoneApplication
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject


class AccountManagerViewModel @Inject constructor() : BaseViewModel() {

    companion object {
        private const val INITIAL_VALUE_WALLET_BALANCE = 100000.00
    }


    private val usereRepository =
        RepositoryFactory.getInstance(WalletStoneApplication.appContext).createUserRepositories()

    private val loginLogoutManagerRepository =
        RepositoryFactory.getInstance(WalletStoneApplication.appContext)
            .createLoginLogoutManagerRepositories()

    private val walletRepository = RepositoryFactory.getInstance(WalletStoneApplication.appContext)
        .creatWalletRepositories()

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

    private val _userLiveData = MutableLiveData<AccountManagerUserState>()
    val userLiveData: LiveData<AccountManagerUserState> = _userLiveData

    fun executeLogin(userNameOrEmail: String, password: String) {
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            postError(throwable)
        }) {

            var user =
                usereRepository.retrieveUserByNameOrEmailAndPassword(userNameOrEmail, password)
            var state = AccountManagerUserState.USER_NOT_FOUND

            user?.let {
                state = AccountManagerUserState.USER_FOUND

                var logged = loginLogoutManagerRepository.insert(LoginLogoutManager(user = user))

                if (logged <= 0) {
                    state = AccountManagerUserState.FAILURE_TO_ON_LOGIN_USER
                }
            }

            _userLiveData.postValue(state)
            updateUiState(UiState.Complete)
        }
    }

    fun saveUser(user: User) {

        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            postError(throwable)
        }) {
            val result = usereRepository.save(user)

            walletRepository.insert(Wallet(result, INITIAL_VALUE_WALLET_BALANCE))

            var state = AccountManagerUserState.USER_CREATED

            if (result == -1L) {
                state = AccountManagerUserState.USER_ALREADY_EXISTS
            }

            _userLiveData.postValue(state)
            updateUiState(UiState.Complete)
        }
    }
}