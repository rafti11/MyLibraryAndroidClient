package com.example.mylibraryapp.di

import com.example.mylibraryapp.data.remote.LibraryAPI
import com.example.mylibraryapp.data.repository.MyLibraryRepositoryImpl
import com.example.mylibraryapp.domain.repository.MyLibraryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
            .baseUrl("http://IP:8080/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LibraryAPI::class.java)
    }


    @Provides
    @Singleton
    fun provideMyLibraryRepository(api: LibraryAPI): MyLibraryRepository {
        return MyLibraryRepositoryImpl(api)
    }


}