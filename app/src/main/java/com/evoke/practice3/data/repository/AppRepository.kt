package com.evoke.practice3.data.repository

import com.evoke.practice3.data.model.User
import com.evoke.practice3.data.network.ApiError
import io.reactivex.disposables.Disposable

interface AppRepository {

    fun getUsers(

            success: (List<User>) -> Unit,
            failure: (ApiError) -> Unit = {},
            terminate: () -> Unit = {}


    ): Disposable
}