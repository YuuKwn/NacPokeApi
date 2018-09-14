package com.yuukwn.nacpokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_resultado_pokemon.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultadoPokemon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_pokemon)
        val bundle = intent.extras
        val id = bundle.getString("id")

        idText.text = id.toString()
        val retrofit=Retrofit.Builder()
                .baseUrl("http://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(PokeapiService::class.java)
        service.buscarPokemon(id.toString())
                .enqueue(object :Callback<Pokemon>{
                    override fun onFailure(call: Call<Pokemon>?, t: Throwable?) {
                        Toast.makeText(this@ResultadoPokemon,"Falha",
                                Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<Pokemon>?, response: Response<Pokemon>?) {
                        val pokemon = response?.body()
                        Picasso.get()
                                .load(pokemon?.sprites?.frontDefault)
                                .into(ivPokeFoto)
                        tvNome.text = pokemon?.nome
                    }
                })

    }
}
