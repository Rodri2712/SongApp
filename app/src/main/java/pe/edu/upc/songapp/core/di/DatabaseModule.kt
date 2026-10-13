package pe.edu.upc.songapp.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.songapp.features.favorites.domain.FavoriteSongRepository
import pe.edu.upc.songapp.features.favorites.infrastructure.local.FavoriteSongDao
import pe.edu.upc.songapp.features.favorites.infrastructure.local.FavoriteSongRepositoryImpl
import pe.edu.upc.songapp.features.favorites.infrastructure.local.SongDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideSongDatabase(
        @ApplicationContext context: Context
    ): SongDatabase {
        return Room.databaseBuilder(
            context,
            SongDatabase::class.java,
            "songapp_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideFavoriteSongDao(
        database: SongDatabase
    ): FavoriteSongDao {
        return database.favoriteSongDao()
    }

    @Provides
    @Singleton
    fun provideFavoriteSongRepository(
        favoriteSongDao: FavoriteSongDao
    ): FavoriteSongRepository {
        return FavoriteSongRepositoryImpl(favoriteSongDao)
    }
}