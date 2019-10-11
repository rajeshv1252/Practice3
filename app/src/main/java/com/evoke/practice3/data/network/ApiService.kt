package com.evoke.practice3.data.network

import com.evoke.practice3.data.model.User
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface ApiService {
    @GET("users")
    fun getUsers(): Observable<List<User>>
}