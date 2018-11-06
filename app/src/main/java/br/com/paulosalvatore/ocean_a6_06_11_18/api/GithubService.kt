package br.com.paulosalvatore.ocean_a6_06_11_18.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories")
    fun searchRepositories(
        @Query("q") query: String
    ): Call<GithubRepositoriesResult>
}
