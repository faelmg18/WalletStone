package br.com.rafaelhfernandes.accountmanager.screen.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.rafaelhfernandes.accountmanager.R
import br.com.rafaelhfernandes.common.extensions.changeStatusBarColor
import br.com.rafaelhfernandes.common.presenter.BaseFragment
import br.com.rafaelhfernandes.common.presenter.components.CustomAlertDialog
import br.com.rafaelhfernandes.common.presenter.components.DialogBuilder
import br.com.rafaelhfernandes.core.presentation.accountmanager.AccountManagerViewModel
import kotlinx.android.synthetic.main.sign_in.*
import javax.inject.Inject

class SignInFragment : BaseFragment<AccountManagerViewModel>() {

    @Inject
    lateinit var factory: AccountManagerViewModel.Factory

    override val viewModel: AccountManagerViewModel by viewModels(factoryProducer = { factory })

    override fun getLayoutId() = R.layout.sign_in

    override fun myOnViewCreated(view: View, savedInstanceState: Bundle?) {
        activity?.changeStatusBarColor(R.color.colorPrimary)

        text_custom_font_create_user.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }

        val listener = object : CustomAlertDialog.DialogBuilderButtonClickListener() {
            override fun onPositiveButtonClick(customAlertDialog: CustomAlertDialog) {
                super.onPositiveButtonClick(customAlertDialog)
                Toast.makeText(context, "PositiveClick", Toast.LENGTH_LONG).show()
            }

            override fun onNegativeButtonClick(customAlertDialog: CustomAlertDialog) {
                super.onNegativeButtonClick(customAlertDialog)
                Toast.makeText(context, "NegativeClick", Toast.LENGTH_LONG).show()
            }
        }

       /* DialogBuilder.showDialog(
            context!!,
            title = getString(R.string.wallet_stone),
            message = "Isso é um teste de Dialog",
            positiveButtonTitle = "Yes",
            negativeButtonTitle = "No",
            buttonClickListener = listener
        ).show()*/

    }
}