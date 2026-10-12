package pe.edu.upc.songapp.features.catalog.domain

interface SongRepository {

    suspend fun getSongs(): List<Song>

    suspend fun getSongById(id: Int): Song
}