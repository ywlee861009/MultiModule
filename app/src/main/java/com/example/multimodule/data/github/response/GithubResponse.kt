package com.example.multimodule.data.github.response

import com.example.multimodule.domain.entity.GithubEntity
import com.google.gson.annotations.SerializedName

/**
 * Github Api Response
 */
data class GithubResponse(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("created_at")
    val date: String? = null,
    @SerializedName("html_url")
    val url: String? = null
)

/**
 * Response > Entity 로 변환
 */
fun Iterable<GithubResponse>.toEntities() = map {
        GithubEntity(
            it.name ?: "",
            it.id ?: "",
            it.date ?: "",
            it.url ?: ""
        )
    }