package br.com.rafaelhfernandes.common.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import br.com.rafaelhfernandes.common.extensions.inflate

abstract class BaseFragment<T : ViewModel> : Fragment() {

    abstract val viewModel: T

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun myOnViewCreated(view: View, savedInstanceState: Bundle?)

    protected open fun myOnCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        // noting to do here
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = activity?.inflate(getLayoutId())
        myOnCreateView(inflater, container, savedInstanceState)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myOnViewCreated(view, savedInstanceState)
    }

    fun setTitle(title: String) {
        view?.findNavController()?.currentDestination?.label = title
    }

    protected fun showBackButton() {
        if (activity is AppCompatActivity) {
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}