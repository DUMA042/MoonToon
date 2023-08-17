package com.example.moontoon.Repositories

import androidx.annotation.WorkerThread
import com.example.moontoon.Dao_Interfaces.Items_Data_BaseDao
import com.example.moontoon.Data_Entities.Item
import kotlinx.coroutines.flow.Flow

class ItemRespository(private val itemDao:Items_Data_BaseDao) {

    val allItems: Flow<List<Item>> = itemDao.getAllItems()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(item: Item) {
        itemDao.insert(item)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(item: Item) {
        itemDao.update(item)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(item: Item) {
        itemDao.delete(item)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun clear() {
        itemDao.clear()
    }

}