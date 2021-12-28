package com.mvi.sample.utils.ktx

import androidx.activity.ComponentActivity
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider


/**
 * Created by ahsan on 19,December,2019
 */

/**
 * Synthetic sugaring to get instance of [ViewModel] for [AppCompatActivity].
 */
//inline fun <reified T : ViewModel> AppCompatActivity.getViewModel(): T {
//    return ViewModelProvider(this, viewModelFactory)[T::class.java]
//}
//
///**
// * Synthetic sugaring to get instance of [ViewModel] for [Fragment].
// */
//inline fun <reified T : ViewModel> Fragment.getViewModel(): T {
//    return ViewModelProvider(this)[T::class.java]
//}
