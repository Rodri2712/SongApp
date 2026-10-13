package pe.edu.upc.songapp.features.catalog.presentation

import pe.edu.upc.songapp.features.catalog.domain.Song

data class SongDetailUiState(
    val song: Song? = null,
    val isFavorite: Boolean = false,
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
    val favoriteErrorMessage: String? = null
)