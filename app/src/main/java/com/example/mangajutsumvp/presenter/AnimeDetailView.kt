package com.example.mangajutsumvp.presenter

import com.example.mangajutsumvp.model.Anime

interface AnimeDetailView {
    fun showAnimeDetails(anime: Anime)
    fun showError(errorMessage: String)
}