package com.example

import kotlin.math.PI

open class Aquarium(
        var width: Int = 20,
        var height: Int = 40,
        var length: Int = 100) {

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open val water = volume * 0.9

    constructor(numberOfFish: Int) : this() {
        val water = numberOfFish * 2000
        val tank = water + water * 0.1
        height = (tank / (length * width)).toInt()
    }
}

class TowerTank() : Aquarium() {
    override var volume: Int
        get() = (width * height * length / 1000 * PI).toInt()
        set(value) {
            height = (value * 1000) / (width * length)
        }

    override val water = volume * 0.8
}

abstract class AquariumFish() {
    abstract val color: String
}

interface FishAction {
    fun eat()
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

interface FishColor {
    val color: String
}

object GoldColor : FishColor {
    override val color = "gold"
}

class Shark() : AquariumFish(), FishAction {
    override val color: String = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}
//
//class Plecostomus() :  FishAction, FishColor by GoldColor {
//     override fun eat() {
//        println("eat algae")
//    }
//}

class Plecostomus(val fishColor: FishColor = GoldColor) :
        FishAction by PrintingFishAction("a lot of algae"),
        FishColor by fishColor

object MobyDicWhale {
    val author = ""
    fun jump() {}
}

enum class Color(value: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

sealed class Seal
class Sealion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal) = when (seal) {
    is Sealion -> "sealion"
    is Walrus -> "walrus"
}


fun main() {
    //delegate()
    //println(extensionsExample())
    printAquariumPlant()
}

fun delegate() {
    val pleco = Plecostomus()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

fun String.hasSpaces() = this.find { it === ' ' } != null

fun extensionsExample(): Boolean {
    return "Does this has spaces".hasSpaces()//
}

fun printAquariumPlant() {
    val plant = AquariumPlant("red", 50)
    println(plant.isRed())
    println(plant.isBig())
    println(plant.red)
}

class AquariumPlant(val color: String, val size: Int)

fun AquariumPlant.isRed() = color == "red"
fun AquariumPlant.isBig() = size > 50
val AquariumPlant.red:Boolean
 get()= color == "red"