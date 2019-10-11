package com.evoke.practice3.di.module

import com.evoke.practice3.data.core.Config
import com.evoke.practice3.data.network.ApiService
import com.evoke.practice3.data.repository.AppRepoImp
import com.evoke.practice3.data.repository.AppRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {
    @Provides
    @Singleton

    internal fun provideRetrofit(): Retrofit {

        return Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Config.HOST)
                .build()
    }


    @Provides
    @Singleton
    fun providesService(retrofit: Retrofit): ApiService {

        return retrofit.create(ApiService::class.java)

    }

    @Provides
    fun providesRepository(appService: ApiService): AppRepository {
        return AppRepoImp(appService)

    }


}