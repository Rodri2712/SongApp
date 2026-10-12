package pe.edu.upc.songapp.features.catalog.infrastructure

import pe.edu.upc.songapp.features.catalog.domain.Song
import pe.edu.upc.songapp.features.catalog.domain.SongRepository

class SongRepositoryImpl(
    private val songApiService: SongApiService
) : SongRepository {

    override suspend fun getSongs(): List<Song> {
        return songApiService.getSongs().results
    }

    override suspend fun getSongById(id: Int): Song {
        return songApiService.getSongById(id)
    }
}