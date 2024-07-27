package com.example.mangajutsumvp.presenter

import com.example.mangajutsumvp.model.Anime

interface AnimeView {
    fun showAnimes(animes: List<Anime>)
    fun showAnimeDetails(anime: Anime)
    fun showError(errorMessage: String)
}