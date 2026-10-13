package pe.edu.upc.songapp.features.catalog.application

import pe.edu.upc.songapp.features.catalog.domain.Song
import pe.edu.upc.songapp.features.catalog.domain.SongRepository

class GetSongByIdUseCase(
    private val songRepository: SongRepository
) {
    suspend operator fun invoke(id: Int): Song {
        return songRepository.getSongById(id)
    }
}