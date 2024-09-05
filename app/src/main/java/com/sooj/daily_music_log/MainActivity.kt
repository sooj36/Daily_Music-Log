package com.sooj.daily_music_log

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sooj.daily_music_log.presentation.MainPageScreen
import com.sooj.daily_music_log.ui.theme.DailyMusicLogTheme
import androidx.navigation.compose.composable
import com.sooj.daily_music_log.presentation.DetailPageScreen
import com.sooj.daily_music_log.presentation.EditDetailPageScreen
import com.sooj.daily_music_log.presentation.PosterListScreen
import com.sooj.daily_music_log.presentation.SearchPageScreen
import com.sooj.daily_music_log.presentation.viewModel.TrackViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val trackViewModel : TrackViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyMusicLogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val musicViewModel = hiltViewModel<TrackViewModel>()
                    NavHost(navController = navController, startDestination = Screen.MainPage.route) {
                        composable(Screen.MainPage.route) { MainPageScreen(navController) }
                        composable(Screen.SearchPage.route) { SearchPageScreen(navController, hiltViewModel())}
                        composable(Screen.PosterList.route) { PosterListScreen(navController, hiltViewModel()) }
                        composable(Screen.DetailPage.route) { DetailPageScreen(navController, hiltViewModel()) }
                        composable(Screen.EditDetailPage.route) { EditDetailPageScreen(navController, hiltViewModel()) }

                    }
                }
            }
        }
    }
}
