package pe.edu.upc.songapp.features.favorites.domain

import kotlinx.coroutines.flow.Flow
import pe.edu.upc.songapp.features.catalog.domain.Song

interface FavoriteSongRepository {

    fun getAllFavorites(): Flow<List<Song>>

    fun isFavorite(songId: Int): Flow<Boolean>

    suspend fun addFavorite(song: Song)

    suspend fun removeFavorite(songId: Int)
}