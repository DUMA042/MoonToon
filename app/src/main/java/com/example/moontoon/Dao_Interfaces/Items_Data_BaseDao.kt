package com.example.moontoon.Dao_Interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.moontoon.Data_Entities.Item_Entity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

@Dao
interface Items_Data_BaseDao {
    @Insert
    fun insert(itemEntity: Item_Entity)

    @Update
    fun update(itemEntity: Item_Entity)

    @Query("DELETE FROM ITEMS_TABLE")
    fun clear()

    @Query("SELECT * FROM items_table " +
           "ORDER BY priority")
    fun getAllItems(): Flow<List<Item_Entity>>

    @Delete
    fun delete(itemEntity: Item_Entity)
}