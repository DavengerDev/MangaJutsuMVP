package com.example.mangajutsumvp.utils


import android.content.Context
import com.example.mangajutsumvp.model.Anime
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader


fun readAnimesFromJson(context: Context): List<Anime> {
    val inputStream = context.assets.open("animes.json")
    val reader = InputStreamReader(inputStream)
    val type = object : TypeToken<List<Anime>>() {}.type
    return Gson().fromJson(reader, type)
}