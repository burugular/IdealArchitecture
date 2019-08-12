package com.rao.com.idealarchitecture.di.component

import com.rao.com.idealarchitecture.IAApplication
import com.rao.com.idealarchitecture.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [ AndroidSupportInjectionModule::class, AppModule::class,
    DatabaseModule::class, NetworkModule::class, RepositoryModule::class,
    ViewModelModule::class, ActivityBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<IAApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: IAApplication): Builder

        fun build(): AppComponent
    }
}