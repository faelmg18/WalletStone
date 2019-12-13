package br.com.rafaelhfernandes.accountmanager.screen.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.rafaelhfernandes.accountmanager.R
import br.com.rafaelhfernandes.accountmanager.dependeciesinjections.DaggerAccountManagerComponent
import br.com.rafaelhfernandes.accountmanager.dependeciesinjections.UserModule
import br.com.rafaelhfernandes.common.extensions.isEmailValid
import br.com.rafaelhfernandes.common.extensions.showToast
import br.com.rafaelhfernandes.common.extensions.validateFieldFilled
import br.com.rafaelhfernandes.common.presenter.BaseFragment
import br.com.rafaelhfernandes.common.presenter.exceptions.FieldNotFiledExeption
import br.com.rafaelhfernandes.core.domain.entities.User
import br.com.rafaelhfernandes.core.presentation.UiState
import br.com.rafaelhfernandes.core.presentation.accountmanager.AccountManagerUserState.USER_ALREADY_EXISTS
import br.com.rafaelhfernandes.core.presentation.accountmanager.AccountManagerUserState.USER_CREATED
import br.com.rafaelhfernandes.core.presentation.accountmanager.AccountManagerViewModel
import br.com.rafaelhfernandes.core.presentation.app.coreComponent
import br.com.rafaelhfernandes.core.security.AESCrypt
import kotlinx.android.synthetic.main.sign_up.*
import javax.inject.Inject

class SignUpFragment : BaseFragment<AccountManagerViewModel>() {

    @Inject
    lateinit var factory: AccountManagerViewModel.Factory

    override val viewModel: AccountManagerViewModel by viewModels(factoryProducer = { factory })

    override fun getLayoutId() = R.layout.sign_up

    override fun myOnViewCreated(view: View, savedInstanceState: Bundle?) {

        DaggerAccountManagerComponent
            .builder()
            .coreComponent(coreComponent())
            .userModule(UserModule())
            .build()
            .inject(this)

        sign_in.setOnClickListener {
            findNavController().popBackStack()
        }
        bindObservables()

        button_create_user.setOnClickListener {
            saveUser()
        }
    }

    private fun bindObservables() {
        viewModel.uiSate.observe(this, Observer {

            if (it is UiState.Error) {
                val message = it.throwable.message
                activity?.showToast(message)
            }
        })

        viewModel.userLiveData.observe(this, Observer { result ->

            when (result) {
                USER_ALREADY_EXISTS -> {
                    activity?.showToast(getString(R.string.user_already_exists))
                }

                USER_CREATED -> {
                    activity?.showToast(getString(R.string.user_created_with_success))
                    findNavController().popBackStack()
                }
            }
        })
    }

    private fun saveUser() {

        try {
            validateFieldFilled(
                text_input_layout_user_name,
                text_input_layout_user_email,
                text_input_layout_password,
                text_input_layout_pin
            )

            if (!text_input_layout_user_email.isEmailValid()) {
                text_input_layout_user_email.error = getString(R.string.invalid_email)
                return
            }

            val userEntity = createUserEntity()
            viewModel.saveUser(userEntity)

        } catch (fieldNotFiledException: FieldNotFiledExeption) {
            Log.e("fieldNotFiledException", fieldNotFiledException.message)
        }
    }

    private fun createUserEntity(): User {

        val userName = text_input_layout_user_name.editText?.text.toString()
        val userEmail = text_input_layout_user_email.editText?.text.toString()
        var password = text_input_layout_password.editText?.text.toString()
        var pin = text_input_layout_pin.editText?.text.toString()

        password = AESCrypt.encrypt(password)
        pin = AESCrypt.encrypt(pin)

        val userEntity =
            User(userName = userName, email = userEmail, password = password, pinCode = pin)

        return userEntity
    }
}