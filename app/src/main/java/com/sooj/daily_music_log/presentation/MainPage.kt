package com.sooj.daily_music_log.presentation

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MainPage(navController : NavController) {
    IconButton(onClick = { navController.navigate("search_page") }) {
        Image(imageVector = Icons.Default.LibraryMusic, contentDescription = "NoteList")
    }
}