package com.example.moontoon.viewModel_files

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moontoon.Data_Entities.Item_Entity
import com.example.moontoon.Repositories.ItemRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(val itemsRep: ItemRespository): ViewModel() {

/*
var number=0
    fun numberInc(){
        number++
    }
    fun getnumber():Int{
        return number
    }*/

    val listofitems = itemsRep.allItems

    fun doitt(itemEntity: Item_Entity){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
            delay(7000L)
            itemsRep.insert(itemEntity)
        }
    }
    }

    fun deleteItem(itemEntity: Item_Entity){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
            itemsRep.delete(itemEntity)
        }
    }
    }

    fun clear(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
            itemsRep.clear() }
        }
    }

    fun insertItem(itemEntity: Item_Entity){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                itemsRep.insert(itemEntity)
            }

        }
    }

    fun updateItem(itemEntity: Item_Entity){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
            itemsRep.update(itemEntity)
            }
        }
    }
}