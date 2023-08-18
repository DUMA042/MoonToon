package com.example.moontoon.di

import android.content.Context
import androidx.room.Room
import com.example.moontoon.Dao_Interfaces.Items_Data_BaseDao
import com.example.moontoon.Database_Abstract.Items_Database
import com.example.moontoon.Repositories.ItemRespository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideItemRepository(itemDao: Items_Data_BaseDao): ItemRespository{
        return ItemRespository(itemDao)
    }

    @Singleton
    @Provides
    fun provideItemDao(appDatabase:Items_Database): Items_Data_BaseDao{
        return  appDatabase.itemDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): Items_Database {
        return Room.databaseBuilder(
            context.applicationContext,
            Items_Database::class.java,
            "word_database"
        ).build()
    }

}