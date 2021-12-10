package com.example.trending.models

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.example.trending.models.BuiltBy
import com.example.trending.models.TrendingRepo
import java.lang.StringBuilder

data class TrendingRepo (
    @SerializedName("rank")
    @Expose
    var rank: Int? = null,

    @SerializedName("username")
    @Expose
    var username: String? = null,

    @SerializedName("repositoryName")
    @Expose
    var repositoryName: String? = null,

    @SerializedName("url")
    @Expose
    var url: String? = null,

    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("language")
    @Expose
    var language: String? = null,

    @SerializedName("languageColor")
    @Expose
    var languageColor: String? = null,

    @SerializedName("totalStars")
    @Expose
    var totalStars: Int? = null,

    @SerializedName("forks")
    @Expose
    var forks: Int? = null,

    @SerializedName("starsSince")
    @Expose
    var starsSince: Int? = null,

    @SerializedName("since")
    @Expose
    var since: String? = null,

    @SerializedName("builtBy")
    @Expose
    var builtBy: List<BuiltBy>? = null
)