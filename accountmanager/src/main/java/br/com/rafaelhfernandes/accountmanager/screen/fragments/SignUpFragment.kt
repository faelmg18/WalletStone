package br.com.rafaelhfernandes.accountmanager.screen.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import br.com.rafaelhfernandes.accountmanager.R
import br.com.rafaelhfernandes.common.presenter.BaseFragment
import br.com.rafaelhfernandes.core.presentation.accountmanager.AccountManagerViewModel
import javax.inject.Inject

class SignUpFragment : BaseFragment<AccountManagerViewModel>() {

    @Inject
    lateinit var factory: AccountManagerViewModel.Factory

    override val viewModel: AccountManagerViewModel by viewModels(factoryProducer = { factory })

    override fun getLayoutId() = R.layout.sign_up

    override fun myOnViewCreated(view: View, savedInstanceState: Bundle?) {
    }

}