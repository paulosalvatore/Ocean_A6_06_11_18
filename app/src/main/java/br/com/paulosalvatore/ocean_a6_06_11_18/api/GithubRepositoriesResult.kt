package br.com.paulosalvatore.ocean_a6_06_11_18.api

import com.google.gson.annotations.SerializedName

data class GithubRepositoriesResult(
    @SerializedName(value = "items")
    val repositories: List<Repository>
)

data class Repository(val id: Long?,
                      val name: String?,
                      val full_name: String?,
                      val owner: Owner,
                      val description: String?)

data class Owner(val login: String?,
                 val id: Long?,
                 var avatar_url: String?)
