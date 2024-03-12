package com.example.task7.di

import android.content.Context
import androidx.room.Room
import com.example.task7.data.datasource.YapilacaklarDataSource
import com.example.task7.data.repo.YapilacaklarRepository
import com.example.task7.room.VeriTabani
import com.example.task7.room.YapilacaklarDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerRepository(kds: YapilacaklarDataSource) : YapilacaklarRepository {
        return YapilacaklarRepository(kds)
    }

    @Provides
    @Singleton
    fun provideKisilerDataSource(kdao: YapilacaklarDao): YapilacaklarDataSource {
        return YapilacaklarDataSource(kdao)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context): YapilacaklarDao {
        val vt = Room.databaseBuilder(context, VeriTabani::class.java, "task7_database.sqlite").createFromAsset("task7_database.sqlite").build()
        return vt.getYapilacaklarDao()
    }
}