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
import br.com.rafaelhfernandes.common.extensions.changeStatusBarColor
import br.com.rafaelhfernandes.common.extensions.showToast
import br.com.rafaelhfernandes.common.extensions.validateFieldFilled
import br.com.rafaelhfernandes.common.presenter.BaseFragment
import br.com.rafaelhfernandes.common.presenter.exceptions.FieldNotFiledExeption
import br.com.rafaelhfernandes.core.presentation.UiState
import br.com.rafaelhfernandes.core.presentation.accountmanager.AccountManagerUserState
import br.com.rafaelhfernandes.core.presentation.accountmanager.AccountManagerViewModel
import br.com.rafaelhfernandes.core.presentation.app.coreComponent
import br.com.rafaelhfernandes.core.security.AESCrypt
import kotlinx.android.synthetic.main.sign_in.*
import javax.inject.Inject

class SignInFragment : BaseFragment<AccountManagerViewModel>() {

    @Inject
    lateinit var factory: AccountManagerViewModel.Factory

    override val viewModel: AccountManagerViewModel by viewModels(factoryProducer = { factory })

    override fun getLayoutId() = R.layout.sign_in

    override fun myOnViewCreated(view: View, savedInstanceState: Bundle?) {

        DaggerAccountManagerComponent
            .builder()
            .coreComponent(coreComponent())
            .userModule(UserModule())
            .build()
            .inject(this)


        activity?.changeStatusBarColor(R.color.colorPrimary)

        text_custom_font_create_user.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }

        login.setOnClickListener {
            executeLogin()
        }

        bindObservables()
    }

    private fun executeLogin() {

        try {
            validateFieldFilled(
                text_input_layout_user_name,
                text_input_layout_password
            )

            val userNameOrEmail = text_input_layout_user_name.editText?.text.toString()
            var password = text_input_layout_password.editText?.text.toString()

            password = AESCrypt.encrypt(password)

            viewModel.executeLogin(userNameOrEmail, password)

        } catch (ex: FieldNotFiledExeption) {
            Log.e("fieldNotFiledException", ex.message)
        }
    }

    private fun bindObservables() {
        viewModel.userSate.observe(this, Observer {
            if (it is UiState.Error) {
                val message = it.throwable.message
                activity?.showToast(message)
            }
        })

        viewModel.userLiveData.observe(this, Observer { result ->

            when (result) {
                AccountManagerUserState.USER_NOT_FOUND -> {
                    activity?.showToast(getString(R.string.user_not_found))
                }

                AccountManagerUserState.USER_FOUND -> {
                    activity?.showToast("Usuário econtrado")
                }
            }
        })
    }
}