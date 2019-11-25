package br.com.rafaelhfernandes.common.extensions

import android.graphics.Typeface
import android.widget.TextView

fun TextView.changeFont(path: String, typeFacedStyle: Int = Typeface.NORMAL) {
    val typeface = Typeface.createFromAsset(context?.assets, path)
    setTypeface(typeface, typeFacedStyle)
}