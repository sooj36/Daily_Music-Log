package com.sooj.daily_music_log.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainPageScreen(navController : NavController) {
    IconButton(onClick = { navController.navigate("search_page") }) {
        Image(imageVector = Icons.Default.LibraryMusic, contentDescription = "NoteList", Modifier.size(150.dp))
    }
}