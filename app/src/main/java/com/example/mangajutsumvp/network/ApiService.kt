package com.example.mangajutsumvp.network

import com.example.mangajutsumvp.model.Anime
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("top_anime")
    suspend fun getTopAnimes(): List<Anime>

    @GET("anime/{id}")
    suspend fun getAnimeDetails(@Path("id") id: Int): Anime

}