package com.example.mangajutsumvp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mangajutsu.view.AnimeListScreen
import com.example.mangajutsumvp.ui.theme.MangaJutsuMVPTheme
import com.example.mangajutsumvp.utils.readAnimesFromJson

class AnimeListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val animes = readAnimesFromJson(this)

        setContent {
            MangaJutsuMVPTheme {
                AnimeListScreen(animes) { animeId ->
                    //TODO descomentar para ir al detalle b
                    /*val intent = Intent(this, AnimeDetailActivity::class.java).apply {
                        putExtra("ANIME_ID", animeId)
                    }
                    startActivity(intent)*/
                }
            }
        }
    }
}