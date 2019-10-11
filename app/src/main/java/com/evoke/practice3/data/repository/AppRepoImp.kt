package com.evoke.practice3.data.repository

import com.evoke.practice3.data.model.User
import com.evoke.practice3.data.network.ApiDisposable
import com.evoke.practice3.data.network.ApiError
import com.evoke.practice3.data.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AppRepoImp(val apiService: ApiService) : AppRepository {


    override fun getUsers(success: (List<User>) -> Unit,
                          failure: (ApiError) -> Unit,
                          terminate: () -> Unit): Disposable {


        return apiService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(terminate)
                .subscribeWith(ApiDisposable<List<User>>(

                        {
                            success(it)
                        }, {
                    failure

                }
                ))

    }


}