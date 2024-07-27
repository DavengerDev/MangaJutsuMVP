package com.example.mangajutsumvp.presenter

import com.example.mangajutsumvp.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimeListPresenter(private val view: AnimeListView) {

    fun fetchTopAnimes() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val animes = RetrofitClient.apiService.getTopAnimes()
                view.showAnimes(animes)
            } catch (e: Exception) {
                view.showError(e.message ?: "Error desconocido")
            }
        }
    }
}