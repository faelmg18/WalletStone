package br.com.rafaelhfernandes.common.presenter.components

import android.app.AlertDialog
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.Log

import androidx.appcompat.widget.AppCompatTextView

import br.com.rafaelhfernandes.common.R
import br.com.rafaelhfernandes.common.extensions.changeFont

class TextViewCustomFont : AppCompatTextView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setCustomFont(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context, attrs, defStyle
    ) {
        setCustomFont(context, attrs)
    }

    private fun setCustomFont(ctx: Context, attrs: AttributeSet) {
        val a = ctx.obtainStyledAttributes(attrs, R.styleable.TextViewPlus)
        val customFont = a.getString(R.styleable.TextViewPlus_customFont)
        val underline = a.getBoolean(R.styleable.TextViewPlus_underline, false)

        if (underline) {
            paintFlags = paintFlags or Paint.UNDERLINE_TEXT_FLAG
        }

        customFont?.let {
            setCustomFont(ctx, it)
        }
        a.recycle()
    }

    private fun setCustomFont(ctx: Context, font: String): Boolean {
        changeFont(font, Typeface.BOLD)
        return true
    }
}
