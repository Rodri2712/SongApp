package pe.edu.upc.songapp.features.catalog.domain

data class Song(
    val id: Int,
    val title: String,
    val artist: String,
    val album: String,
    val year: Int,
    val duration: Int,
    val genre: String,
    val rating: Double,
    val image: String
)