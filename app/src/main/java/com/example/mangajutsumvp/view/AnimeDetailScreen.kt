package com.example.mangajutsumvp.view
import androidx.compose.runtime.Composable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mangajutsumvp.model.Anime
import com.example.mangajutsumvp.presenter.AnimeDetailPresenter
import com.example.mangajutsumvp.presenter.AnimeDetailView
import com.example.mangajutsumvp.ui.theme.MangaJutsuMVPTheme

class AnimeDetailScreen : ComponentActivity(), AnimeDetailView {

    private lateinit var presenter: AnimeDetailPresenter
    private var anime by mutableStateOf<Anime?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = AnimeDetailPresenter(this)
        val animeId = intent.getIntExtra("ANIME_ID", 0)
        setContent {
            MangaJutsuMVPTheme {
                AnimeDetailContent(anime)
            }
        }
        presenter.fetchAnimeDetails(animeId)
    }

    override fun showAnimeDetails(anime: Anime) {
        this.anime = anime
    }

    override fun showError(errorMessage: String) {
        // Manejar el error (mostrar un mensaje, etc.)
    }
}

@Composable
fun AnimeDetailContent(anime: Anime?) {
    anime?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(it.imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = it.title, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = it.description, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimeDetailPreview() {
    MangaJutsuMVPTheme {
        AnimeDetailContent(
            anime = Anime(1, "Fullmetal Alchemist: Brotherhood", "Two brothers search for a Philosopher's Stone.", "https://example.com/fullmetal_alchemist.jpg")
        )
    }
}