package com.example.pokedex.data.remote.responses


import com.google.gson.annotations.SerializedName

data class PokemonList(
    @SerializedName("count")
    val count: Int, // 1302
    @SerializedName("next")
    val next: String, // https://pokeapi.co/api/v2/pokemon?offset=20&limit=20
    @SerializedName("previous")
    val previous: Any, // null
    @SerializedName("results")
    val results: List<Result>
) {
    data class Result(
        @SerializedName("name")
        val name: String, // bulbasaur
        @SerializedName("url")
        val url: String // https://pokeapi.co/api/v2/pokemon/1/
    )
}