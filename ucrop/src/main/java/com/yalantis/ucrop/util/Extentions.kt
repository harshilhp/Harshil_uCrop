package com.yalantis.ucrop.util

import android.app.Activity
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding


/******************** View extensions ********************/
fun View.applyWindowInsets(activity: Activity? = null) {
    ViewCompat.setOnApplyWindowInsetsListener(this) { view, windowInsets ->
        val systemBarInsets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
        val imeInsets = windowInsets.getInsets(WindowInsetsCompat.Type.ime())
        view.updatePadding(left = systemBarInsets.left, bottom = imeInsets.bottom.takeIf { it > 0 } ?: systemBarInsets.bottom, right = systemBarInsets.right, top = systemBarInsets.top)
        WindowInsetsCompat.CONSUMED
    }
}