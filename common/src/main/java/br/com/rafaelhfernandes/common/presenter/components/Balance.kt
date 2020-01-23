package br.com.rafaelhfernandes.common.presenter.components

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import br.com.rafaelhfernandes.common.R
import br.com.rafaelhfernandes.common.extensions.inflate
import kotlinx.android.synthetic.main.balance.view.*

class Balance : LinearLayout {

    var currencySymbol: String? = ""

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context, attrs, defStyle
    ) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        val view = context.inflate(R.layout.balance)

        view.image_view_show_balance.setOnClickListener {
            showBalance()
        }

        view.image_view_hide_balance.setOnClickListener {
            hideBalance()
        }

        attrs?.let {
            val a = context.obtainStyledAttributes(attrs, R.styleable.balanceView)
            currencySymbol = a.getString(R.styleable.balanceView_currencySymbol)

            if (!currencySymbol.isNullOrEmpty()) {
                view.money_textview.setSymbol(currencySymbol)
            }
        }


        addView(view)
    }

    fun setAmount(amount: Float) {
        money_textview.amount = amount
    }

    private fun hideBalance() {

        money_textview.visibility = View.GONE
        text_view_balance_hide.visibility = View.VISIBLE
        image_view_show_balance.visibility = View.VISIBLE
        image_view_hide_balance.visibility = View.GONE
    }

    private fun showBalance() {
        money_textview.visibility = View.VISIBLE
        text_view_balance_hide.visibility = View.GONE
        image_view_show_balance.visibility = View.GONE
        image_view_hide_balance.visibility = View.VISIBLE
    }
}