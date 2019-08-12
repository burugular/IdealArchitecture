package com.rao.com.idealarchitecture.ui.main.base

import android.arch.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {

   abstract fun start()

    abstract fun stop()
}