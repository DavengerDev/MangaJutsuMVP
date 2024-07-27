package com.example.mangajutsumvp.presenter

import com.example.mangajutsumvp.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class AnimePresenter(private val view: AnimeView) {

    fun fetchTopAnimes(){
        //CoroutineScope: Lugar donde puedo lanzar la rutina
        //Dispachers: Lo que asegura que la tarea se haga en el hilo principal (las que afectan a la UI)
        //launch: Empezar una tarea nueva de forma asíncrona
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val animes = RetrofitClient.apiService.getTopAnimes()
                view.showAnimes(animes)
            } catch (e: Exception) {
                view.showError(e.message ?: "Error desconocido")
            }
        }
    }

    //TODO Mejor en una clase separada o todo en el mismo Presenter??
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