package com.example.moontoon.Repositories

import androidx.annotation.WorkerThread
import com.example.moontoon.Dao_Interfaces.Items_Data_BaseDao
import com.example.moontoon.Data_Entities.Item_Entity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first

class ItemRespository(private val itemDao:Items_Data_BaseDao) {

    val allItems: Flow<List<Item_Entity>> = itemDao.getAllItems()



    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(itemEntity: Item_Entity) {
        itemDao.insert(itemEntity)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(itemEntity: Item_Entity) {
        itemDao.update(itemEntity)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(itemEntity: Item_Entity) {
        itemDao.delete(itemEntity)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun clear() {
        itemDao.clear()
    }

}