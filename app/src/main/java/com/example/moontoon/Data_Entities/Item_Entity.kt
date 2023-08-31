package com.example.moontoon.Data_Entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "items_table",indices = [Index(value = ["name"],
    unique = true)])
data class Item_Entity(@PrimaryKey(autoGenerate = true)
                       var uid: Long =0L,
                       val name: String?,
                       val description: String?,
                       var madeTime: Long= System.currentTimeMillis(),
                       var doneTime:Long= madeTime,
                       var priority: Int=-1)

