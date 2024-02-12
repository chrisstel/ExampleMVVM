package com.example.examplemvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examplemvvm.model.User
import com.example.examplemvvm.model.UserSharedPref

class MainViewModel(
    private val userSharedPref: UserSharedPref
) : ViewModel() {
    private val userLiveData = MutableLiveData<User>()
    fun getUserLiveData(): LiveData<User> = userLiveData

    fun save(username: String, email: String) {
        userSharedPref.save(username, email)
    }

    fun load() {
        userLiveData.value = userSharedPref.load()
    }

}