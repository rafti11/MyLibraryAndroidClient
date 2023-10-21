package com.example.mylibraryapp.di

import android.content.Context
import android.content.SharedPreferences
import com.example.mylibraryapp.data.SharedPreferencesManager
import com.example.mylibraryapp.data.remote.LibraryAPI
import com.example.mylibraryapp.data.repository.MyLibraryRepositoryImpl
import com.example.mylibraryapp.domain.repository.MyLibraryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLibraryAPI(): LibraryAPI {
        return Retrofit.Builder()
            .baseUrl("http://10.10.2.12:8080/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LibraryAPI::class.java)
    }


    @Provides
    @Singleton
    fun provideMyLibraryRepository(api: LibraryAPI): MyLibraryRepository {
        return MyLibraryRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideSharedPreferencesManager(@ApplicationContext context: Context): SharedPreferencesManager {
        return SharedPreferencesManager(context)
    }

}