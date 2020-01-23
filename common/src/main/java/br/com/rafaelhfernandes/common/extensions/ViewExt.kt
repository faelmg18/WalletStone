package br.com.rafaelhfernandes.common.extensions

import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateDecelerateInterpolator
import kotlin.math.hypot
import kotlin.math.max


fun View.circularRevealAnimation(duration: Long = 1250) {

    val cx = (left + right) / 2
    val cy = (top + bottom) / 2

    // get the final radius for the clipping circle
    val dx = max(cx, 1000 - cx)
    val dy = max(cy, 1000 - cy)
    val finalRadius = hypot(dx.toDouble(), dy.toDouble()).toFloat()

    val animator =
        ViewAnimationUtils.createCircularReveal(this, cx, cy, 0f, finalRadius)
    animator.interpolator = AccelerateDecelerateInterpolator()
    animator.duration = duration
    animator.start()
}
