package com.example.moontoon.viewModel_files

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moontoon.Data_Entities.Item
import com.example.moontoon.Repositories.ItemRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(val itemsRep: ItemRespository): ViewModel() {

    val listofitems = itemsRep.allItems

    fun deleteItem(item: Item){
        viewModelScope.launch {
            itemsRep.delete(item)
        }
    }

    fun clear(){
        viewModelScope.launch { itemsRep.clear() }
    }

    fun insertItem(item: Item){
        viewModelScope.launch {
            itemsRep.insert(item)
        }
    }

    fun updateItem(item: Item){
        viewModelScope.launch {
            itemsRep.update(item)
        }
    }
}