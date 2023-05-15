package com.circlemove.sample.di

import com.circlemove.sample.repo.SampleRepository
import com.circlemove.sample.repo.SampleRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SampleModule {
    @Provides
    @Singleton
    fun provideSampleRepository(): SampleRepository = SampleRepositoryImpl()
}