package pe.edu.upc.songapp.features.favorites.infrastructure.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import pe.edu.upc.songapp.features.catalog.domain.Song

@Entity(tableName = "favorite_songs")
data class FavoriteSongEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val artist: String,
    val album: String,
    val year: Int,
    val duration: Int,
    val genre: String,
    val rating: Double,
    val image: String
) {
    fun toSong(): Song {
        return Song(
            id = id,
            title = title,
            artist = artist,
            album = album,
            year = year,
            duration = duration,
            genre = genre,
            rating = rating,
            image = image
        )
    }

    companion object {
        fun fromSong(song: Song): FavoriteSongEntity {
            return FavoriteSongEntity(
                id = song.id,
                title = song.title,
                artist = song.artist,
                album = song.album,
                year = song.year,
                duration = song.duration,
                genre = song.genre,
                rating = song.rating,
                image = song.image
            )
        }
    }
}