package com.evoke.practice3.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
        @Expose
        @SerializedName("name")
        var name: String
)