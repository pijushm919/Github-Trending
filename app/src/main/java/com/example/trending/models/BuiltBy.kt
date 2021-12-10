package com.example.trending.models

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.example.trending.models.BuiltBy
import com.example.trending.models.TrendingRepo
import java.lang.StringBuilder

data class BuiltBy (
    @SerializedName("username")
    @Expose
    var username: String? = null,

    @SerializedName("url")
    @Expose
    var url: String? = null,

    @SerializedName("avatar")
    @Expose
    var avatar: String? = null
)