package com.sooj.daily_music_log.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicVideo
import androidx.compose.material.icons.filled.SaveAlt
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.sooj.daily_music_log.R
import com.sooj.daily_music_log.presentation.viewModel.TrackViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditDetailPageScreen(navController: NavController, musicViewModel: TrackViewModel) {
    val clickedTrack by musicViewModel.selectedTrack
    val getImageUrl by musicViewModel.getImage
    Log.d("수정위한 클릭 트릭 가져오기", "정보 : ${clickedTrack}")
    val scrollState = rememberScrollState()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Image(imageVector = Icons.Default.MusicVideo, contentDescription = "NoteList")
                }

                IconButton(onClick = { navController.navigate("edit_detail_page") }) {
                    Image(imageVector = Icons.Default.SaveAlt, contentDescription = "save")
                }
            }
            Box(modifier = Modifier) {
                Column(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (getImageUrl != null) {
                        Log.d("edit_이미지이미지", "이미지 URL: ${getImageUrl}")
                        AsyncImage(model = getImageUrl, contentDescription = "image")
                    } else {
                        Image(painterResource(id = R.drawable.image_icon), contentDescription = "error")
                    }

                    Text(
                        text = clickedTrack?.artist ?: "알 수 없 는 아티스트",
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(25.dp)
                            .padding(start = 8.dp)
                    )
                    Text(
                        text = clickedTrack?.name ?: "알 수 없 는 제목",
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(25.dp)
                            .padding(start = 8.dp)
                    )

                    var text by remember {
                        mutableStateOf("")
                    }
                    TextField(value = text, onValueChange = { text = it })

                    Card(
                        shape = RoundedCornerShape(30.dp),
                        modifier = Modifier
                            .background(Color.Transparent)
                            .padding(20.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(20.dp),
                            text = "Hello, hello\n" +
                                    "I'm not where I'm supposed to be\n" +
                                    "I hope that you're missin' me\n" +
                                    "'Cause it makes me feel young\n" +
                                    "Hello, hello\n" +
                                    "Last time that I saw your face\n" +
                                    "Was recess in second grade\n" +
                                    "And it made me feel young\n" +
                                    "Won't you help me sober up?\n" +
                                    "Growin' up, it made me numb\n" +
                                    "And I wanna feel somethin' again\n" +
                                    "Won't you help me sober up?\n" +
                                    "All the big kids, they got drunk\n" +
                                    "And I want to feel somethin' again (Oh, oh, oh, oh)\n" +
                                    "Won't you help me feel somethin' again?\n" +
                                    "How's it go again?\n" +
                                    "\"Goodbye, goodbye\"\n" +
                                    "I said to my best-est buds\n" +
                                    "We said that we'd keep in touch\n" +
                                    "And we did our best\n" +
                                    "All my new friends\n" +
                                    "We smile at party time\n" +
                                    "But soon we forget to smile\n" +
                                    "At anything else\n" +
                                    "Won't you help me sober up?\n" +
                                    "Growin' up, it made me numb\n" +
                                    "And I want to feel somethin' again\n" +
                                    "Won't you help me sober up?\n" +
                                    "All the big kids, they got drunk\n" +
                                    "And I want to feel somethin' again (Oh, oh, oh, oh)\n" +
                                    "Won't you help me feel somethin' again?\n" +
                                    "How's it go again?\n" +
                                    "How's it go again? (Go again, go again, go again…)\n" +
                                    "My favorite color is you\n" +
                                    "You're vibratin' out my frequency\n" +
                                    "My favorite color is you\n" +
                                    "You keep me young and that's how I wanna be\n" +
                                    "My favorite color is you\n" +
                                    "You're vibratin' out my frequency\n" +
                                    "My favorite color is you\n" +
                                    "You keep me young and that's how I wanna be\n" +
                                    "I'm not where I'm supposed to be\n" +
                                    "I hope that you're missin' me\n" +
                                    "'Cause it makes me feel young\n" +
                                    "Hello, hello\n" +
                                    "Last time that I saw your face\n" +
                                    "Was recess in second grade\n" +
                                    "And it made me feel young\n" +
                                    "And I want to feel somethin' again\n" +
                                    "I just wanna feel somethin' again\n" +
                                    "How's it go again?\n" +
                                    "Won't you help me sober up?\n" +
                                    "Growin' up, it made me numb\n" +
                                    "And I want to feel somethin' again (My favorite color is you)\n" +
                                    "Won't you help me sober up?\n" +
                                    "All the big kids, they got drunk\n" +
                                    "And I want to feel somethin' again (My favorite color is you)\n" +
                                    "Won't you help me feel somethin' again? (My favorite color is you)\n" +
                                    "Can I finally feel somethin' again?\n" +
                                    "How's it go again?\n"
                        )
                    }
                }
            }
        }
    }
}