package com.example.multimodule

import com.google.gson.annotations.SerializedName

/**
 * Github Api Response
 */
data class GithubRepo(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("created_at")
    val date: String? = null,
    @SerializedName("html_url")
    val url: String? = null
)