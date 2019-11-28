package br.com.rafaelhfernandes.accountmanager.dependeciesinjections

import br.com.rafaelhfernandes.accountmanager.screen.fragments.SignInFragment
import br.com.rafaelhfernandes.accountmanager.screen.fragments.SignUpFragment
import br.com.rafaelhfernandes.core.dependenciesinjections.CoreComponent
import dagger.Component

@Component(dependencies = [CoreComponent::class], modules = [UserModule::class])
interface AccountManagerComponent {
    fun inject(signInFragment: SignInFragment)
    fun inject(signUpFragment: SignUpFragment)
}