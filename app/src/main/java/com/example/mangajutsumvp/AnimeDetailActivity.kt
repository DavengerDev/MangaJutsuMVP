package com.example.mangajutsumvp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class AnimeDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeDetailActivity()
        }
    }
}
