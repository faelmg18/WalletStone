package br.com.rafaelhfernandes.common.extensions

import android.content.Context
import android.view.LayoutInflater

fun Context.inflate(resId: Int) =
    LayoutInflater.from(this).inflate(resId, null)
