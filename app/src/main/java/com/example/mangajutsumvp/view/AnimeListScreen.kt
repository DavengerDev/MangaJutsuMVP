// view/AnimeListScreen.kt
package com.example.mangajutsu.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mangajutsumvp.model.Anime
import com.example.mangajutsumvp.ui.theme.MangaJutsuMVPTheme

@Composable
fun AnimeListScreen(animes: List<Anime>, onAnimeClick: (Int) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(animes) { anime ->
            AnimeGridItem(anime, onAnimeClick)
        }
    }
}

@Composable
fun AnimeGridItem(anime: Anime, onAnimeClick: (Int) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize()
            .clickable { onAnimeClick(anime.id) }
    ) {
        Image(
            painter = rememberAsyncImagePainter(anime.imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxWidth()
        )
        Text(
            text = anime.title,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AnimeListPreview() {
    MangaJutsuMVPTheme {
        AnimeListScreen(
            animes = listOf(
                Anime(1, "Fullmetal Alchemist: Brotherhood", "Two brothers search for a Philosopher's Stone.", "https://example.com/fullmetal_alchemist.jpg"),
                Anime(2, "Attack on Titan", "Humans fight against giants.", "https://example.com/attack_on_titan.jpg"),
                Anime(3, "One Piece", "A boy with stretchy powers sets out to find the One Piece treasure.", "https://example.com/one_piece.jpg"),
                Anime(4, "Dragon Ball Z", "Warriors with incredible powers defend Earth from powerful enemies.", "https://example.com/dragon_ball_z.jpg"),
                Anime(5, "Death Note", "A high school student discovers a notebook that allows him to kill anyone.", "https://example.com/death_note.jpg"),
                Anime(6, "Naruto", "A young ninja seeks recognition from his peers and dreams of becoming the Hokage.", "https://example.com/naruto.jpg"),
                Anime(7, "Neon Genesis Evangelion", "Teenagers pilot giant robots to protect Earth from mysterious beings.", "https://example.com/neon_genesis_evangelion.jpg"),
                Anime(8, "Hunter x Hunter", "A young boy searches for his father who is a legendary Hunter.", "https://example.com/hunter_x_hunter.jpg"),
                Anime(9, "Code Geass: Lelouch of the Rebellion", "A prince gains a power that compels anyone to obey his orders.", "https://example.com/code_geass.jpg"),
                Anime(10, "My Hero Academia", "A boy without superpowers enrolls in an academy for heroes.", "https://example.com/my_hero_academia.jpg"),
                Anime(11, "Berserk", "A lone mercenary battles his way through a medieval world filled with demons.", "https://example.com/berserk.jpg"),
                Anime(12, "Demon Slayer", "A young boy becomes a demon slayer to avenge his family and cure his sister.", "https://example.com/demon_slayer.jpg")
            )
        ) { /* No-op for preview */ }
    }
}