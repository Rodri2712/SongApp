package pe.edu.upc.songapp.features.favorites.infrastructure.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pe.edu.upc.songapp.features.catalog.domain.Song
import pe.edu.upc.songapp.features.favorites.domain.FavoriteSongRepository

class FavoriteSongRepositoryImpl(
    private val favoriteSongDao: FavoriteSongDao
) : FavoriteSongRepository {

    override fun getAllFavorites(): Flow<List<Song>> {
        return favoriteSongDao.getAllFavorites()
            .map { favorites ->
                favorites.map { entity -> entity.toSong() }
            }
    }

    override fun isFavorite(songId: Int): Flow<Boolean> {
        return favoriteSongDao.isFavorite(songId)
    }

    override suspend fun addFavorite(song: Song) {
        favoriteSongDao.insertFavorite(
            FavoriteSongEntity.fromSong(song)
        )
    }

    override suspend fun removeFavorite(songId: Int) {
        favoriteSongDao.deleteFavorite(songId)
    }
}