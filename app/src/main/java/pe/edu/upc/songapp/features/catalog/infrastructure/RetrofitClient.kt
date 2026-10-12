package pe.edu.upc.songapp.features.catalog.infrastructure

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL =
        "https://songapi-fcbahjbha7dabkan.eastus-01.azurewebsites.net/"

    val songApiService: SongApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SongApiService::class.java)
    }
}