package br.com.rafaelhfernandes.common.extensions

import android.app.Activity
import android.widget.Toast

fun Activity.showToast(message: String?, time: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, time).show()
}