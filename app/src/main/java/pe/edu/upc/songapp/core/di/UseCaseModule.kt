package pe.edu.upc.songapp.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.songapp.features.catalog.application.GetSongByIdUseCase
import pe.edu.upc.songapp.features.catalog.application.GetSongsUseCase
import pe.edu.upc.songapp.features.catalog.domain.SongRepository
import pe.edu.upc.songapp.features.favorites.application.AddFavoriteUseCase
import pe.edu.upc.songapp.features.favorites.application.GetFavoriteSongsUseCase
import pe.edu.upc.songapp.features.favorites.application.IsFavoriteUseCase
import pe.edu.upc.songapp.features.favorites.application.RemoveFavoriteUseCase
import pe.edu.upc.songapp.features.favorites.domain.FavoriteSongRepository

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetSongsUseCase(
        repository: SongRepository
    ): GetSongsUseCase {
        return GetSongsUseCase(repository)
    }

    @Provides
    fun provideGetSongByIdUseCase(
        repository: SongRepository
    ): GetSongByIdUseCase {
        return GetSongByIdUseCase(repository)
    }

    @Provides
    fun provideGetFavoriteSongsUseCase(
        repository: FavoriteSongRepository
    ): GetFavoriteSongsUseCase {
        return GetFavoriteSongsUseCase(repository)
    }

    @Provides
    fun provideIsFavoriteUseCase(
        repository: FavoriteSongRepository
    ): IsFavoriteUseCase {
        return IsFavoriteUseCase(repository)
    }

    @Provides
    fun provideAddFavoriteUseCase(
        repository: FavoriteSongRepository
    ): AddFavoriteUseCase {
        return AddFavoriteUseCase(repository)
    }

    @Provides
    fun provideRemoveFavoriteUseCase(
        repository: FavoriteSongRepository
    ): RemoveFavoriteUseCase {
        return RemoveFavoriteUseCase(repository)
    }
}