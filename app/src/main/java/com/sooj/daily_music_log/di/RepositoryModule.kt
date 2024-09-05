package com.sooj.daily_music_log.di

import com.sooj.daily_music_log.data.TrackRepositoryImpl
import com.sooj.daily_music_log.domain.TrackRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsSearchRepository(
        trackRepositoryImpl: TrackRepositoryImpl
    ) : TrackRepository
}