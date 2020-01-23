package br.com.rafaelhfernandes.shop.screens.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import br.com.rafaelhfernandes.common.presenter.BaseFragment
import br.com.rafaelhfernandes.core.presentation.app.coreComponent
import br.com.rafaelhfernandes.core.presentation.shop.ShopHomeViewModel
import br.com.rafaelhfernandes.shop.R
import br.com.rafaelhfernandes.shop.dependencieinjections.DaggerShopComponent
import br.com.rafaelhfernandes.shop.dependencieinjections.ShopModule
import javax.inject.Inject

class ShopHomeFragment : BaseFragment<ShopHomeViewModel>() {

    @Inject
    lateinit var factory: ShopModule.Factory<ShopHomeViewModel>

    override val viewModel: ShopHomeViewModel by viewModels(factoryProducer = { factory })

    override fun getLayoutId(): Int = R.layout.shop_home_fragment

    override fun myOnViewCreated(view: View, savedInstanceState: Bundle?) {
        DaggerShopComponent.builder()
            .coreComponent(coreComponent())
            .shopModule(ShopModule())
            .build()
            .inject(this)

        viewModel.tesxte()
    }

}