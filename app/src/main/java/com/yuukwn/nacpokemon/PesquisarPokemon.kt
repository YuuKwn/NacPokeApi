package com.yuukwn.nacpokemon

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_pesquisar_pokemon.*

class PesquisarPokemon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisar_pokemon)
    }
    fun Pesquisar(view:View){
    val id = etPokemon.text.toString()
        val intent = Intent(this, ResultadoPokemon::class.java)

        intent.putExtra("id", id)

        startActivity(intent)
        finish()

    }


}
