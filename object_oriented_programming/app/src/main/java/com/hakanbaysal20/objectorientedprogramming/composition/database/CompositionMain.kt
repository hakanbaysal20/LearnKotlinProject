package com.hakanbaysal20.objectorientedprogramming.composition.database

fun main() {


    val category = Categories(1,"Dram")
    val category1 = Categories(2,"Komedi")
    val director = Directors(1,"Quentin Tarrantino")
    val director1 = Directors(2,"Cristopher Nolan")

    val film = Films(1,"Django",2013,category,director)

    println("Film id            : ${film.film_id}")
    println("Film name          : ${film.film_name}")
    println("Film year          : ${film.film_year}")
    println("Film category name : ${film.categories.category_name}")
    println("Film director name : ${film.directors.director_name}")
}