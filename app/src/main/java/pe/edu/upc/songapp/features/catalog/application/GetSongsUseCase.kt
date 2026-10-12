package pe.edu.upc.songapp.features.catalog.application

import pe.edu.upc.songapp.features.catalog.domain.Song
import pe.edu.upc.songapp.features.catalog.domain.SongRepository

class GetSongsUseCase(
    private val songRepository: SongRepository
) {

    suspend operator fun invoke(): List<Song> {
        return songRepository.getSongs()
    }
}