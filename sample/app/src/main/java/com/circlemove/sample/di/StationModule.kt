package com.circlemove.sample.di

import com.circlemove.sample.repo.StationRepository
import com.circlemove.sample.repo.StationRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StationModule {
    @Provides
    @Singleton
    fun provideStationRepository(): StationRepository = StationRepositoryImpl()
}