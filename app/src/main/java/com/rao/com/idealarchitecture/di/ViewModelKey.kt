package com.rao.com.idealarchitecture.di

import android.arch.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass


@Target(allowedTargets = [AnnotationTarget.FUNCTION])
@Retention(value = AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)