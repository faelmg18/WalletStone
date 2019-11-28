package br.com.rafaelhfernandes.core.framework

import android.net.Uri
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator
import br.com.rafaelhfernandes.core.presentation.utils.navigateUriWithDefaultOptions

const val ACCOUNT_MANAGER_SIGN_IN = "walletstone://signinfragment"
const val PRODUCT_DETAILS_URI = "pocmodularnavigation://productdetails"
const val REPOSITORY_DETAILS_URI = "pocmodularnavigation://repositoriesdetailfragment"
const val PRODUCT_DETAILS_FRAGMENT_URI = "pocmodularnavigation://productdetailfragment"

fun View.goToProduct(extras: FragmentNavigator.Extras? = null) =
    gotoNextScreen(extras, PRODUCT_DETAILS_URI)

fun View.goToMyAccountAndClearAllBackStack(extras: FragmentNavigator.Extras? = null) {
    goToSignIn(extras, true)
}

fun View.goToSignIn(extras: FragmentNavigator.Extras? = null, clearAll: Boolean = false) =
    gotoNextScreen(extras = extras, uri = ACCOUNT_MANAGER_SIGN_IN, inclusive = false, clearAll = clearAll)

fun View.goToRepositoryDetail(extras: FragmentNavigator.Extras? = null) =
    gotoNextScreen(extras = extras, uri = REPOSITORY_DETAILS_URI, inclusive = false, clearAll = false)

fun View.goToProductDetailFragment(extras: FragmentNavigator.Extras? = null) =
    gotoNextScreen(extras = extras, uri = PRODUCT_DETAILS_FRAGMENT_URI, inclusive = false, clearAll = false)
private fun View.clearBackStack(): Boolean = findNavController().popBackStack()

private fun View.gotoNextScreen(
    extras: FragmentNavigator.Extras?,
    uri: String,
    inclusive: Boolean = false,
    clearAll: Boolean = false
) {
    if (clearAll) {
        while (clearBackStack()) {
            //noting to do
        }
    }
    findNavController().navigateUriWithDefaultOptions(
        uri = Uri.parse(uri),
        extras = extras,
        inclusive = inclusive
    )
}

fun View.findNavController(): NavController = Navigation.findNavController(this)