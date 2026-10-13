package pe.edu.upc.songapp.features.favorites.application

import kotlinx.coroutines.flow.Flow
import pe.edu.upc.songapp.features.catalog.domain.Song
import pe.edu.upc.songapp.features.favorites.domain.FavoriteSongRepository

class GetFavoriteSongsUseCase(
    private val repository: FavoriteSongRepository
) {
    operator fun invoke(): Flow<List<Song>> {
        return repository.getAllFavorites()
    }
}