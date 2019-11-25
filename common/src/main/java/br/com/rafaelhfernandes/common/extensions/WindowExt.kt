package br.com.rafaelhfernandes.common.extensions

import android.app.Activity
import android.view.WindowManager
import androidx.core.content.ContextCompat


fun Activity.changeStatusBarColor(resColorId: Int) {

// clear FLAG_TRANSLUCENT_STATUS flag:
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

// finally change the color
    window.statusBarColor = ContextCompat.getColor(this, resColorId)
}