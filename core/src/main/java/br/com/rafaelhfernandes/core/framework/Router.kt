package br.com.rafaelhfernandes.core.framework

import android.net.Uri
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator
import br.com.rafaelhfernandes.core.presentation.utils.navigateUriWithDefaultOptions

const val ACCOUNT_MANAGER_SIGN_IN = "walletstone://signinfragment"
const val HOME_FRAGMENT_URI = "walletstone://homefragment"

fun View.gotoHome(extras: FragmentNavigator.Extras? = null) =
    gotoNextScreen(extras, HOME_FRAGMENT_URI, inclusive = false, clearAll = true)

fun View.goToSignIn(extras: FragmentNavigator.Extras? = null, clearAll: Boolean = false) =
    gotoNextScreen(
        extras = extras,
        uri = ACCOUNT_MANAGER_SIGN_IN,
        inclusive = false,
        clearAll = clearAll
    )

private fun View.clearBackStack(): Boolean = findNavController().popBackStack()

private fun View.gotoNextScreen(
    extras: FragmentNavigator.Extras?,
    uri: String,
    inclusive: Boolean = false,
    clearAll: Boolean = false
) {
    if (clearAll) {
        while (clearBackStack()) { //noting to do
        }
    }
    findNavController().navigateUriWithDefaultOptions(
        uri = Uri.parse(uri),
        extras = extras,
        inclusive = inclusive
    )
}

fun View.findNavController(): NavController = Navigation.findNavController(this)