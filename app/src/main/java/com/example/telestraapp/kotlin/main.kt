package com.example.telestraapp.kotlin

fun main() {

    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

   // println( decorations.filter {it[0] == 'p'})
   /* val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")*/

    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")


    /*val lazyMap = decorations.asSequence().map {
        println("access: $it")// create a list on access of the first element
        it
    }

    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")*/
}