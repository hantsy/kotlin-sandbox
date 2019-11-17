package com.example

fun main(args: Array<String>) {
    val greetings = " ${if(args[0].toInt() < 12) "Good morning, Kotlin" else "Good night, Kotlin" }"
    println(greetings)
}
