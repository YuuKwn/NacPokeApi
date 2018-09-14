package com.yuukwn.nacpokemon

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
interface PokeapiService {
    @GET("/api/v2/pokemon/{id}/")
    fun buscarPokemon(@Path("id") id:String) : Call<Pokemon>
}