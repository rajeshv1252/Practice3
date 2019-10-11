package com.evoke.practice3.di.builder

import android.arch.lifecycle.ViewModel
import com.evoke.practice3.di.qualifier.ViewModelKey
import com.evoke.practice3.ui.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

}