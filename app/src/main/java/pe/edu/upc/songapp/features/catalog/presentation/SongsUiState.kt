package pe.edu.upc.songapp.features.catalog.presentation

import pe.edu.upc.songapp.features.catalog.domain.Song

data class SongsUiState(
    val songs: List<Song> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)