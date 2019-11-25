package br.com.rafaelhfernandes.core.presentation.app

import android.app.Activity
import android.app.Application
import android.app.Service
import android.content.Context
import androidx.fragment.app.Fragment
import br.com.rafaelhfernandes.core.dependenciesinjections.CoreComponent
import br.com.rafaelhfernandes.core.dependenciesinjections.DaggerCoreComponent
import br.com.rafaelhfernandes.core.framework.RepositoryFactory

class WalletStoneApplication : Application() {
    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.create()
    }

    companion object {
        lateinit var appContext: Context
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as WalletStoneApplication).coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        RepositoryFactory.getInstance(applicationContext)
    }
}

fun Activity.coreComponent() =
    WalletStoneApplication.coreComponent(
        this
    )

fun Fragment.coreComponent() =
    WalletStoneApplication.coreComponent(
        requireContext()
    )

fun Service.coreComponent() =
    WalletStoneApplication.coreComponent(
        this
    )