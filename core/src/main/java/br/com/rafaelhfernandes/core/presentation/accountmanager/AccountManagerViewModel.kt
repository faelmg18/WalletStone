package br.com.rafaelhfernandes.core.presentation.accountmanager

import androidx.lifecycle.*
import br.com.rafaelhfernandes.core.domain.entities.LoginLogoutManager
import br.com.rafaelhfernandes.core.domain.entities.User
import br.com.rafaelhfernandes.core.framework.RepositoryFactory
import br.com.rafaelhfernandes.core.presentation.BaseViewModel
import br.com.rafaelhfernandes.core.presentation.UiState
import br.com.rafaelhfernandes.core.presentation.app.WalletStoneApplication
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject


class AccountManagerViewModel @Inject constructor() : BaseViewModel() {

    private val usereRepository =
        RepositoryFactory.getInstance(WalletStoneApplication.appContext).creatUserRepositories()

    private val loginLogoutManagerRepository =
        RepositoryFactory.getInstance(WalletStoneApplication.appContext)
            .creatLoginLogoutManagerRepositories()

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

    private val _userState = MutableLiveData<UiState>()
    val userSate: LiveData<UiState> = _userState

    private val _userLiveData = MutableLiveData<AccountManagerUserState>()
    val userLiveData: LiveData<AccountManagerUserState> = _userLiveData

    fun executeLogin(userNameOrEmail: String, password: String) {
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            _userState.postValue(UiState.Error(throwable))
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
            _userState.postValue(UiState.Complete)
        }
    }

    fun saveUser(user: User) {

        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            _userState.postValue(UiState.Error(throwable))
        }) {
            val result = usereRepository.save(user)

            var state = AccountManagerUserState.USER_CREATED

            if (result == -1L) {
                state = AccountManagerUserState.USER_ALREADY_EXISTS
            }

            _userLiveData.postValue(state)
            _userState.postValue(UiState.Complete)
        }
    }
}