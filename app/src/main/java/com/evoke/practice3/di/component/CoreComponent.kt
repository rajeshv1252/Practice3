package com.evoke.practice3.di.component

import android.app.Application
import com.evoke.practice3.data.core.App
import com.evoke.practice3.di.builder.ActvityBuilder
import com.evoke.practice3.di.module.ContextModule
import com.evoke.practice3.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class),
    (NetworkModule::class), (ActvityBuilder::class), (ContextModule::class)])
interface CoreComponent : AndroidInjector<App> {


    @Component.Builder
    interface Buider {
        @BindsInstance
        fun application(application: Application): Buider

        fun build(): CoreComponent
    }

}