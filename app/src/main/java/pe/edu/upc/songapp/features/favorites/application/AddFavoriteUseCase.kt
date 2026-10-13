package pe.edu.upc.songapp.features.favorites.application

import pe.edu.upc.songapp.features.catalog.domain.Song
import pe.edu.upc.songapp.features.favorites.domain.FavoriteSongRepository

class AddFavoriteUseCase(
    private val repository: FavoriteSongRepository
) {
    suspend operator fun invoke(song: Song) {
        repository.addFavorite(song)
    }
}