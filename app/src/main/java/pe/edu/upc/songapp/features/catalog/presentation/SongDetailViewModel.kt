package pe.edu.upc.songapp.features.catalog.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.edu.upc.songapp.features.catalog.application.GetSongByIdUseCase
import pe.edu.upc.songapp.features.catalog.domain.Song
import pe.edu.upc.songapp.features.favorites.application.AddFavoriteUseCase
import pe.edu.upc.songapp.features.favorites.application.IsFavoriteUseCase
import pe.edu.upc.songapp.features.favorites.application.RemoveFavoriteUseCase

@HiltViewModel
class SongDetailViewModel @Inject constructor(
    private val getSongByIdUseCase: GetSongByIdUseCase,
    private val isFavoriteUseCase: IsFavoriteUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SongDetailUiState())
    val uiState: StateFlow<SongDetailUiState> = _uiState.asStateFlow()

    private var currentSongId: Int? = null

    fun loadSong(songId: Int) {
        if (currentSongId == songId) return
        currentSongId = songId

        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    errorMessage = null,
                    favoriteErrorMessage = null
                )
            }

            try {
                val song = getSongByIdUseCase(songId)

                _uiState.update {
                    it.copy(song = song, isLoading = false)
                }

                observeFavorite(songId)
            } catch (exception: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = exception.localizedMessage
                    )
                }
            }
        }
    }

    private fun observeFavorite(songId: Int) {
        viewModelScope.launch {
            isFavoriteUseCase(songId).collectLatest { isFavorite ->
                _uiState.update {
                    it.copy(isFavorite = isFavorite)
                }
            }
        }
    }

    fun toggleFavorite() {
        val song: Song = _uiState.value.song ?: return

        viewModelScope.launch {
            try {
                if (_uiState.value.isFavorite) {
                    removeFavoriteUseCase(song.id)
                } else {
                    addFavoriteUseCase(song)
                }
            } catch (exception: Exception) {
                _uiState.update {
                    it.copy(
                        favoriteErrorMessage = exception.localizedMessage
                    )
                }
            }
        }
    }
}