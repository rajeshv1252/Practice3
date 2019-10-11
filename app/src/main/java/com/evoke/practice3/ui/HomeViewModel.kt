package com.evoke.practice3.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.evoke.practice3.data.model.User
import com.evoke.practice3.data.network.ApiError
import com.evoke.practice3.data.repository.AppRepository
import com.evoke.practice3.ui.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(appRepository: AppRepository) : BaseViewModel() {


    private val homeData: MutableLiveData<List<User>> by lazy { MutableLiveData<List<User>>() }
    val error: MutableLiveData<ApiError> by lazy { MutableLiveData<ApiError>() }


    fun getUsers(): LiveData<List<User>> {
        return homeData
    }


    init {

        Log.e("Viewmodel ", "INIT")
        appRepository.getUsers({ userList ->
            Log.e("Viewmodel ", "postValue")
            homeData.postValue(userList)
            Log.e("Viewmodel ", "INIT")
        }, {

            error.value = it
            Log.e("Viewmodel ", "postValue" + it)
        }).also { compositeDisposable.add(it) }
    }


}