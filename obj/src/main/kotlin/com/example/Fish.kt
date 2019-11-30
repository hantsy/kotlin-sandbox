package com.example

class Fish(val friendly: Boolean = true, volumeNeeded: Int) {
    init {
        println("first init block")
    }

    val size: Int

    constructor() : this(true, 9) {
        println("running secondary constructor")
    }

    init {
        if (friendly) {
            this.size = volumeNeeded
        } else {
            this.size = volumeNeeded * 2
        }
    }

    init {
        println("constructed fish with size $volumeNeeded, final size ${this.size}")
    }

    init {
        println("last init block")
    }

}

fun makeDefaultFish() {
    println("Fish:" + Fish(true, 50))
}

fun fishExample() {
    val fish = Fish(false, 20)
    println("is this fish friendly? ${fish.friendly}. It needs volume ${fish.size}")
}

fun main() {
    makeDefaultFish()
    fishExample()
}