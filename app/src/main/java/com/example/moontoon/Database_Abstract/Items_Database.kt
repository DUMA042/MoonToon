package com.example.moontoon.Database_Abstract

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moontoon.Dao_Interfaces.Items_Data_BaseDao
import com.example.moontoon.Data_Entities.Item_Entity

@Database(entities = [Item_Entity::class],version = 1, exportSchema = false)
abstract class Items_Database: RoomDatabase(){

    abstract fun itemDao(): Items_Data_BaseDao

    companion object{

        @Volatile
        private var INSTANCE: Items_Database? = null

        fun getInstance(context: Context): Items_Database{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Items_Database::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }


}
