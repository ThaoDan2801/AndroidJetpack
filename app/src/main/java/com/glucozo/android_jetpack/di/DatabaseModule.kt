package com.glucozo.android_jetpack.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.glucozo.android_jetpack.database.TaskDao
import com.glucozo.android_jetpack.database.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)// cac class nay se ton tai theo lifecycle cua ung dung
class DatabaseModule {
    @Provides
    @Singleton
    fun provideTaskDatabase(application: Application): TaskDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            TaskDatabase::class.java,
            "task.db"
        ).build()
    }
    @Provides
    @Singleton
    fun provideTaskDao(db:TaskDatabase): TaskDao{
        return db.getTaskDao()
    }

    @Provides
    @Singleton
    fun provideSharePreference(application: Application):SharedPreferences{
        return application.applicationContext.getSharedPreferences("abc", Context.MODE_PRIVATE)
    }
}