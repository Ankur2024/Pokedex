package com.example.pokedex.repository

import com.example.pokedex.data.remote.PokeApi
import com.example.pokedex.data.remote.responses.Pokemon
import com.example.pokedex.data.remote.responses.PokemonList
import com.example.pokedex.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.io.IOException
import retrofit2.HttpException
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        return try {
            val response = api.getPokemonList(limit, offset)
            Resource.Success(response)
        } catch (e: IOException) {
            Resource.Error("Network error: Please check your internet connection")
        } catch (e: HttpException) {
            Resource.Error("Server error: ${e.message()} (Code: ${e.code()})")
        } catch (e: Exception) {
            Resource.Error("An unexpected error occurred: ${e.localizedMessage ?: "Unknown error"}")
        }
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return try {
            val response = api.getPokemonInfo(pokemonName)
            Resource.Success(response)
        } catch (e: IOException) {
            Resource.Error("Network error: Please check your internet connection")
        } catch (e: HttpException) {
            Resource.Error("Server error: ${e.message()} (Code: ${e.code()})")
        } catch (e: Exception) {
            Resource.Error("An unexpected error occurred: ${e.localizedMessage ?: "Unknown error"}")
        }
    }
}
