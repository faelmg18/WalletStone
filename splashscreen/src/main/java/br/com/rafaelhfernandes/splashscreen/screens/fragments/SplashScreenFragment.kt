package br.com.rafaelhfernandes.splashscreen.screens.fragments

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import br.com.rafaelhfernandes.common.extensions.changeFont
import br.com.rafaelhfernandes.common.presenter.BaseFragment
import br.com.rafaelhfernandes.core.framework.RepositoryFactory
import br.com.rafaelhfernandes.core.presentation.app.coreComponent
import br.com.rafaelhfernandes.core.presentation.price.PriceViewModel
import br.com.rafaelhfernandes.splashscreen.R
import br.com.rafaelhfernandes.splashscreen.dependeciesinjections.DaggerSplashComponent
import br.com.rafaelhfernandes.splashscreen.dependeciesinjections.PriceModule
import kotlinx.android.synthetic.main.splash_screen_fragment.*
import javax.inject.Inject


class SplashScreenFragment : BaseFragment<PriceViewModel>() {

    @Inject
    lateinit var factory: PriceViewModel.Factory

    override val viewModel: PriceViewModel by viewModels(factoryProducer = { factory })

    lateinit var animationFromBottom: Animation
    lateinit var animationFromTop: Animation
    lateinit var animationFromLeft: Animation
    lateinit var animationFadeIn: Animation

    override fun getLayoutId(): Int = R.layout.splash_screen_fragment

    override fun myOnViewCreated(view: View, savedInstanceState: Bundle?) {

        DaggerSplashComponent
            .builder()
            .priceModule(PriceModule())
            .coreComponent(coreComponent())
            .build()
            .inject(this)

        textViewWallet.changeFont("fonts/AllRoundGothicW01Demi.otf", Typeface.BOLD)

        animationFromBottom = AnimationUtils.loadAnimation(context, R.anim.frombottom)
        animationFromTop = AnimationUtils.loadAnimation(context, R.anim.fromrigth)
        animationFromLeft = AnimationUtils.loadAnimation(context, R.anim.fromleft)
        animationFadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in)

        imageViewBitCoinIcon.animation = animationFromBottom
        textViewWallet.animation = animationFromTop
        appCompatImageViewStone.animation = animationFromLeft
        textViewDevelopedBy.animation = animationFadeIn


        viewModel.priceObservable.observe(this, Observer {

        })
        viewModel.getPriceState.observe(this, Observer {

        })
    }
}