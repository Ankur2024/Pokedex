package com.example.pokedex.di

import com.example.pokedex.data.remote.PokeApi
import com.example.pokedex.repository.PokemonRepository
import com.example.pokedex.utils.Constants.BASE_URL
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    fun providePokemonRepository(
        api: PokeApi
    ) = PokemonRepository(api)

    fun providePokiApi(): PokeApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }
}