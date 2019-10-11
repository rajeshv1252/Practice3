package com.evoke.practice3.di.builder

import com.evoke.practice3.ui.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders {

    @ContributesAndroidInjector
    abstract fun provideHomeFragement(): HomeFragment

}