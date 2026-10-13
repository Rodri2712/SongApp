package pe.edu.upc.songapp.features.favorites.infrastructure.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [FavoriteSongEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SongDatabase : RoomDatabase() {

    abstract fun favoriteSongDao(): FavoriteSongDao
}