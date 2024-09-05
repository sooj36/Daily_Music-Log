package com.sooj.daily_music_log.presentation.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sooj.daily_music_log.domain.TrackRepository
import com.sooj.daily_music_log.domain.api_model.Track
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
            Log.d("sj_vm(↓) GETMUSIC", "Running on thread: ${Thread.currentThread().name}")
            try {
                val trackInfo = repository.getMusic_impl(track)
                withContext(Dispatchers.Main) {
                    _searchList.value = trackInfo
                }
            } catch (e : Exception) {
                Log.e("sj getmusic vm", "ERROR FETCHING TRACK INFO ${e.message}")
            }
            Log.d("sj_vm(↑) GETMUSIC", "Running on thread: ${Thread.currentThread().name}")
        }
    }

    /** 셀렉 트랙 */
    fun selectedTrack_vm(track: Track) {
        _selectedTrack.value = track //사용자가 선택한 track을 전달받아 상태 갱신

        getPoster_vm()
    }

    /** 셀렉 트랙으로 get 포스터 */
    fun getPoster_vm() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("sj_vm(↓) GETPOSTER", "Running on thread: ${Thread.currentThread().name}")
           // 일단 선택한 트랙 값 가져와야해
            val selectTrack = _selectedTrack.value ?: return@launch

            if (selectTrack != null) {
                val ImageUrl = selectTrack.image?.find { it.size == "large" }?.url
                withContext(Dispatchers.Main) {
                    _getImage.value = ImageUrl
                    Log.d("sj_vm getposter withcontext", "Running on thread: ${Thread.currentThread().name}")
                }
            } else {
                Log.e("앨범 정보 에러", "앨범 정보 못 가져옴 $")
            }
            Log.d("sj_vm(↑) GETPOSTER", "Running on thread: ${Thread.currentThread().name}")
        }
    }

    /** 데이터 불러오는 메서드 */

}