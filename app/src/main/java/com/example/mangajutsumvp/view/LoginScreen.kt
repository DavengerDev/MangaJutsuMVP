package com.example.mangajutsumvp.view

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mangajutsumvp.AnimeListActivity
import com.example.mangajutsumvp.R
import com.google.firebase.auth.FirebaseAuth


@Composable
fun LoginScreen() {
    val context = LocalContext.current

    var email by remember { mutableStateOf("angeldmora7@gmail.com") }
    var password by remember { mutableStateOf("123456") }

    // Instancia de FirebaseAuth para la autenticación
    val auth = FirebaseAuth.getInstance()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF101010)) // Fondo oscuro para un buen contraste
    ) {
        // Fondo con imagen
        Image(
            painter = painterResource(id = R.drawable.background_login),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Contenido principal
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.luffy),
                contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
                    .clip(RoundedCornerShape(20.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val intent = Intent(context, AnimeListActivity::class.java)
                                    context.startActivity(intent)
                                    (context as? androidx.activity.ComponentActivity)?.finish()
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Authentication Failed",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    } else {
                        Toast.makeText(
                            context,
                            "Email and Password must not be empty",
                            Toast.LENGTH_SHORT
                        ).show()
                    }


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text(text = "LOGIN", fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Register",
                color = Color.Gray,
                modifier = Modifier.clickable {
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Toast.makeText(context, "User Created", Toast.LENGTH_SHORT)
                                        .show()
                                } else {
                                    val exceptionMessage =
                                        task.exception?.message ?: "User Creation Failed"
                                    Toast.makeText(
                                        context,
                                        exceptionMessage,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    Log.e(
                                        "FirebaseAuth",
                                        "User creation failed",
                                        task.exception
                                    )
                                }
                            }
                    } else {
                        Toast.makeText(
                            context,
                            "Email and Password must not be empty",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Forgot Password?",
                color = Color.Gray,
                modifier = Modifier.clickable { /* Acción de recuperación de contraseña */ }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.calavera), // Asegúrate de que el nombre del recurso sea correcto
                contentDescription = null,
                modifier = Modifier.size(100.dp) // Ajusta el tamaño según sea necesario
            )
        }
    }
}


/*
@Composable
fun LoginScreen() {
    MangaJutsuMVPTheme {
        // Obtiene el contexto actual
        val context = LocalContext.current

        // Variables de estado para el email y la contraseña
        var email by remember { mutableStateOf("angeldmora7@gmail.com") }
        var password by remember { mutableStateOf("123456") }

        // Instancia de FirebaseAuth para la autenticación
        val auth = FirebaseAuth.getInstance()

        // Diseña una columna que centraliza su contenido
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Campo de texto para ingresar el email
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // Campo de texto para ingresar la contraseña, con visualización de contraseña oculta
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // Botón de login
            Button(
                onClick = {
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val intent = Intent(context, AnimeListActivity::class.java)
                                    context.startActivity(intent)
                                    (context as? androidx.activity.ComponentActivity)?.finish()
                                } else {
                                    Toast.makeText(context, "Authentication Failed", Toast.LENGTH_SHORT).show()
                                }
                            }
                    } else {
                        Toast.makeText(context, "Email and Password must not be empty", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Login")
            }

            // Botón de registro
            Button(
                onClick = {
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Toast.makeText(context, "User Created", Toast.LENGTH_SHORT).show()
                                } else {
                                    val exceptionMessage = task.exception?.message ?: "User Creation Failed"
                                    Toast.makeText(context, exceptionMessage, Toast.LENGTH_SHORT).show()
                                    Log.e("FirebaseAuth", "User creation failed", task.exception)
                                }
                            }
                    } else {
                        Toast.makeText(context, "Email and Password must not be empty", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Sign Up")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}*/
