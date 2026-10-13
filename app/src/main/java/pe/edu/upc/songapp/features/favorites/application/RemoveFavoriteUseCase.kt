package pe.edu.upc.songapp.features.favorites.application

import pe.edu.upc.songapp.features.favorites.domain.FavoriteSongRepository

class RemoveFavoriteUseCase(
    private val repository: FavoriteSongRepository
) {
    suspend operator fun invoke(songId: Int) {
        repository.removeFavorite(songId)
    }
}