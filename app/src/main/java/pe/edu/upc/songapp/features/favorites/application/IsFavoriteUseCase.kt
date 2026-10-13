package pe.edu.upc.songapp.features.favorites.application

import kotlinx.coroutines.flow.Flow
import pe.edu.upc.songapp.features.favorites.domain.FavoriteSongRepository

class IsFavoriteUseCase(
    private val repository: FavoriteSongRepository
) {
    operator fun invoke(songId: Int): Flow<Boolean> {
        return repository.isFavorite(songId)
    }
}