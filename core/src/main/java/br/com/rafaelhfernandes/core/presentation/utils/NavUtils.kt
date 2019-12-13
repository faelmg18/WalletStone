package br.com.rafaelhfernandes.core.presentation.utils

import android.net.Uri
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigator
import br.com.rafaelhfernandes.core.R

fun createDefaultNavOptions(destination: Int, inclusive: Boolean = false) = NavOptions.Builder()
    .setLaunchSingleTop(false)
    .setPopUpTo(destination, inclusive)
    .setEnterAnim(R.anim.nav_default_enter_anim)
    .setExitAnim(R.anim.nav_default_exit_anim)
    .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
    .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
    .build()

fun NavController.navigateUriWithDefaultOptions(
    uri: Uri, extras: FragmentNavigator.Extras? = null, inclusive: Boolean = false
) {
    this.navigate(
        uri,
        createDefaultNavOptions(this.currentDestination?.id ?: -1, inclusive),
        extras
    )
}