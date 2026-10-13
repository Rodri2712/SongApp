package pe.edu.upc.songapp.features.favorites.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import pe.edu.upc.songapp.features.catalog.domain.Song
import pe.edu.upc.songapp.features.favorites.application.GetFavoriteSongsUseCase
import pe.edu.upc.songapp.features.favorites.application.RemoveFavoriteUseCase

@HiltViewModel
class FavoriteSongsViewModel @Inject constructor(
    getFavoriteSongsUseCase: GetFavoriteSongsUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase
) : ViewModel() {

    val favoriteSongs: StateFlow<List<Song>> =
        getFavoriteSongsUseCase()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    fun removeFavorite(songId: Int) {
        viewModelScope.launch {
            removeFavoriteUseCase(songId)
        }
    }
}