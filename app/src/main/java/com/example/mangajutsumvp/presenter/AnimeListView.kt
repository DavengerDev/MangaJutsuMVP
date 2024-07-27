package com.example.mangajutsumvp.presenter

import com.example.mangajutsumvp.model.Anime

interface AnimeListView {
    fun showAnimes(animes: List<Anime>)
    fun showError(errorMessage: String)
}