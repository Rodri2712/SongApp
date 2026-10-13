package pe.edu.upc.songapp.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.songapp.features.catalog.domain.SongRepository
import pe.edu.upc.songapp.features.catalog.infrastructure.SongApiService
import pe.edu.upc.songapp.features.catalog.infrastructure.SongRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL =
        "https://songapi-fcbahjbha7dabkan.eastus-01.azurewebsites.net/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideSongApiService(
        retrofit: Retrofit
    ): SongApiService {
        return retrofit.create(SongApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideSongRepository(
        songApiService: SongApiService
    ): SongRepository {
        return SongRepositoryImpl(songApiService)
    }
}