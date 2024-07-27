package com.example.mangajutsumvp.view

import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mangajutsumvp.LoginActivity
import com.example.mangajutsumvp.R
import com.example.mangajutsumvp.ui.theme.MangaJutsuMVPTheme

@Composable
fun SplashScreen() {
    MangaJutsuMVPTheme {
        val context = LocalContext.current

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.splash_screen),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "MangaJutsu",
                    fontSize = 40.sp,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 60.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(context, LoginActivity::class.java)
                    context.startActivity(intent)
                    // Finish the splash activity to remove it from the back stack
                    (context as? androidx.activity.ComponentActivity)?.finish()
                }, 3000) // Delay of 3 seconds before moving to MainActivity
            }
        }
    }
}