package com.example.moontoon.viewModel_files

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moontoon.Data_Entities.Item_Entity
import com.example.moontoon.Repositories.ItemRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(val itemsRep: ItemRespository): ViewModel() {

    val listofitems = itemsRep.allItems

    fun deleteItem(itemEntity: Item_Entity){
        viewModelScope.launch {
            itemsRep.delete(itemEntity)
        }
    }

    fun clear(){
        viewModelScope.launch { itemsRep.clear() }
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
            itemsRep.update(itemEntity)
        }
    }
}