package com.example

fun main(args: Array<String>) {
    makeDecorations()
}

fun makeDecorations() {
    val d1 = Decorations("granite")
    println(d1)
    val d2 = Decorations("slate")
    println(d2)
    println("d1 == d2:" + (d1 == d2))

    val d3 = Decorations("slate")
    println("d2 == d3:" + (d2 == d3))

    val d4 = d3.copy()
    println("d3 == d4:" + (d3 == d4))

    val d5 = Decorations2("crystal", "wood", "diver")
    println(d5)

    val (sock, wood, diver) = d5
    println(sock)
    println(wood)
    println(diver)

}

data class Decorations(val socks: String)
data class Decorations2(val socks: String, val wood: String, val diver: String)