package br.com.rafaelhfernandes.core.extentions

import android.app.Activity
import android.R
import androidx.core.content.ContextCompat
import android.view.WindowManager


fun Activity.changeStatusColor(resId: Int) {

// clear FLAG_TRANSLUCENT_STATUS flag:
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

// finally change the color
    window.setStatusBarColor(ContextCompat.getColor(this, resId))
}