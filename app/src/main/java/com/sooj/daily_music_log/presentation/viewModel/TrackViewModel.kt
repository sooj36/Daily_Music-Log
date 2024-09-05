package com.sooj.daily_music_log.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sooj.daily_music_log.domain.TrackRepository
import com.sooj.daily_music_log.domain.api_model.Track
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackViewModel @Inject constructor(
    private val repository: TrackRepository
) : ViewModel() {

    // 1. 검색 //
    private val _searchList = mutableStateOf<List<Track>>(emptyList())
    val searchList : State<List<Track>> get() = _searchList

    // 2. 선택 //
    private val _selectedTrack = mutableStateOf<Track?>(null)
    val selectedTrack: State<Track?> get() = _selectedTrack


    // 3. 선택 트랙에서 메소드 두개 추출 //
    private val _getImage = mutableStateOf<String?>(null)
    val getImage : State<String?> get() = _getImage

    // 4 모든 트랙 데이터 상태 관리 //
  /**  private val _allTracks = mutableStateOf<List<TrackEntity>>(emptyList())
    val allTracks : State<List<TrackEntity>> get() = _allTracks */


    fun getMusic_vm(track: String) {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }


}