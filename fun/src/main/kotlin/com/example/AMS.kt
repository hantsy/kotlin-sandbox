package com.example

import java.util.*

fun main() {
    feedTheFish()
//    canAddFish(10.0, listOf(3,3,3)) //---> false
//    canAddFish(8.0, listOf(2,2,2), hasDecorations = false) //---> true
//    canAddFish(9.0, listOf(1,1,3), 3) //---> false
//    canAddFish(10.0, listOf(), 7, true) //---> true
    eagerExample()
}

fun eagerExample() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    val eager = decorations.filter { it[0] == 'p' }
    println(eager)
    //apply filter lazily
    val lazilyFilter = decorations.asSequence().filter { it[0] == 'p' }
    println(lazilyFilter)
    println(lazilyFilter.toList())

    val lazilyMap = decorations.asSequence().map {
        println("map:$it")
        it
    }
    println(lazilyMap)
    println("first:" + lazilyMap.first())
    println("all:" + lazilyMap.toList())
}

fun shouldChangeWater(
        day: String,
        temperature: Int = 20,
        dirty: Int = 20
): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 20
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

fun feedTheFish() {
    val day = radomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    shouldChangeWater(day, 20, 50)
    shouldChangeWater(day)
    shouldChangeWater(day, dirty = 50)
    if (shouldChangeWater(day)) {
        println("Change water today")
    }
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }

}

fun radomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}

var dirty = 20
val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
fun feedFish(dirty: Int) = dirty + 10
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty, { dirty -> dirty + 50 })
}