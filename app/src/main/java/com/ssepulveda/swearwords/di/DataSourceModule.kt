package com.ssepulveda.swearwords.di

import com.ssepulveda.swearwords.data.ApiDataSource
import com.ssepulveda.swearwords.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideApiDataSource(service: ApiService) = ApiDataSource(service)
}