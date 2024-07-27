package com.example.mangajutsumvp.presenter

import com.example.mangajutsumvp.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimeDetailPresenter(private val view: AnimeDetailView) {

    fun fetchAnimeDetails(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val anime = RetrofitClient.apiService.getAnimeDetails(id)
                view.showAnimeDetails(anime)
            } catch (e: Exception) {
                view.showError(e.message ?: "Error desconocido")
            }
        }
    }
}