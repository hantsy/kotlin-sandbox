package com.example

fun main() {
    buildAquarium()
    makeFish()
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    println("Length: ${myAquarium.length}" +
            "Width: ${myAquarium.width}" +
            "Height: ${myAquarium.height}")

    myAquarium.height = 80
    println("Length:${myAquarium.length} cms")
    println("Volume: ${myAquarium.volume} liters")

    val smallAquarium = Aquarium(length = 20, width = 15, height = 30)
    println("Small aquarium volume: ${smallAquarium.volume} liters")

    val myAquarium2 = Aquarium(numberOfFish = 9)

    println("Small aquarium2: ${myAquarium2.volume} liters" +
            "Length: ${myAquarium2.length}" +
            "Width: ${myAquarium2.width}" +
            "Height: ${myAquarium2.height}")
}

fun feedFish(fishAction: FishAction) {
    fishAction.eat()
}

fun makeFish() {
    val shark = Shark()
    val plecostomus = Plecostomus()
    println("Shark color: ${shark.color}")
    println("Plecostomus color: ${plecostomus.color}")

    shark.eat()
    plecostomus.eat()
}