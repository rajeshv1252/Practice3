package com.evoke.practice3.di.builder

import com.evoke.practice3.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActvityBuilder {
    @ContributesAndroidInjector(modules = [MainActivityProviders::class])
    abstract fun bindActivity(): MainActivity
}