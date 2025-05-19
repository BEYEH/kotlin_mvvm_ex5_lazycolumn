package com.example.kotlin_mvvvm_ex5_lazy_column.Model

import com.example.kotlin_mvvvm_ex5_lazy_column.R

data class MarvelChar(
    var charName: String,
    var name: String,
    var imageRes: Int
)

fun getAllMarvelChars(): List<MarvelChar>{
    return listOf<MarvelChar>(
        MarvelChar("Deadpool", "Ryan Reynolds", R.drawable.deadpool),
        MarvelChar("Iron Man", "Robert Downey Jr.", R.drawable.ironman),
        MarvelChar("Captain America", "Chris Evans", R.drawable.captain_america)
    )
}
