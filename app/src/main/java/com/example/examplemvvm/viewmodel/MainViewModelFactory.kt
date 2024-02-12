package com.example.examplemvvm.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.examplemvvm.model.UserSharedPref

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {
    private val userSharedPref = UserSharedPref(context = context)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(userSharedPref) as T
    }
}