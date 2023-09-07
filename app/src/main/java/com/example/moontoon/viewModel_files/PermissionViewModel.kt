package com.example.moontoon.viewModel_files

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class PermissionViewModel: ViewModel() {

    val visiblePermissionDialogQueue = mutableStateListOf<String>()

    fun displayDialog(){
        visiblePermissionDialogQueue.removeLast()
    }

    fun onPermissionResult(permission: String, isGranted: Boolean){
        if(!isGranted){
            visiblePermissionDialogQueue.add(0,permission)
        }
    }
}