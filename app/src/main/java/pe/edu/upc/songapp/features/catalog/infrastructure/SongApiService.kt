package pe.edu.upc.songapp.features.catalog.infrastructure

import pe.edu.upc.songapp.features.catalog.domain.Song
import retrofit2.http.GET
import retrofit2.http.Path

data class SongsResponse(
    val count: Int,
    val results: List<Song>
)

interface SongApiService {

    @GET("api/songs")
    suspend fun getSongs(): SongsResponse

    @GET("api/songs/{id}")
    suspend fun getSongById(
        @Path("id") id: Int
    ): Song
}