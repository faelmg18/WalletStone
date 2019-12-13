package br.com.rafaelhfernandes.home.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import br.com.rafaelhfernandes.common.extensions.circularRevealAnimation
import br.com.rafaelhfernandes.common.presenter.BaseFragment
import br.com.rafaelhfernandes.core.presentation.app.coreComponent
import br.com.rafaelhfernandes.core.presentation.home.HomeViewModel
import br.com.rafaelhfernandes.home.R
import br.com.rafaelhfernandes.home.dependeciesinjections.DaggerTransasionComponent
import br.com.rafaelhfernandes.home.dependeciesinjections.TransasionModule
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject


class TransactionsHomeFragment : BaseFragment<HomeViewModel>() {

    @Inject
    lateinit var factory: HomeViewModel.Factory

    override val viewModel: HomeViewModel by viewModels(factoryProducer = { factory })

    override fun getLayoutId(): Int = R.layout.home_fragment

    override fun myOnViewCreated(view: View, savedInstanceState: Bundle?) {

        DaggerTransasionComponent.builder()
            .coreComponent(coreComponent())
            .transasionModule(TransasionModule())
            .build().inject(this)

        curveBg.circularRevealAnimation()

        bindObservables()
        viewModel.getBalance()
    }

    private fun bindObservables() {
        viewModel.walletLiveData.observe(this, Observer {
            money_textview.amount = it.balance.toFloat()
        })
    }
}