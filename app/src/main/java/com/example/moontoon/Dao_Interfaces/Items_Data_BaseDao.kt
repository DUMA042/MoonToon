package com.example.moontoon.Dao_Interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.moontoon.Data_Entities.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface Items_Data_BaseDao {
    @Insert
    fun insert(item: Item)

    @Update
    fun update(item: Item)

    @Query("DELETE FROM ITEMS_TABLE")
    fun clear()

    @Query("SELECT * FROM items_table " +
           "ORDER BY priority")
    fun getAllItems(): Flow<List<Item>>

    @Delete
    fun delete(item: Item)
}