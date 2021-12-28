package com.mvi.sample.utils.ktx

import android.view.View

/**
 * Created by ahsan on 04,November,2019
 */

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}
