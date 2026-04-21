package com.example.composetask.di

import android.content.Context
import androidx.room.Room
import com.example.composetask.data.TaskRepositoryImpl
import com.example.composetask.data.local.AppDatabase
import com.example.composetask.data.local.TaskDao
import com.example.composetask.data.remote.FakeApi
import com.example.composetask.domain.TaskRepository
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
    fun provideDataBase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "task_db"
        ).build()
    }

    @Provides
    fun providesTaskDao(db: AppDatabase): TaskDao {
        return db.taskDao()
    }

    @Provides
    @Singleton
    fun provideFakeApi(): FakeApi {
        return FakeApi()
    }

    @Provides
    @Singleton
    fun provideRepository(
        dao: TaskDao,
        api: FakeApi
    ): TaskRepository {
        return TaskRepositoryImpl(dao, api)
    }

}