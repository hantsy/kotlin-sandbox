package aquarium5

data class Fish(var name: String)

fun main(args: Array<String>) {
    fishExamples()
}

fun fishExamples() {
    val fish = Fish("fish")
    with(fish.name) {
        this.capitalize()
        //println(this)
    }

    myWith(fish.name) {
        println(this.capitalize())
    }

    println(fish.run {
        println(this)
        name
    })

    val fish2 = Fish("fish2").apply { name = "Fish 2" };
    println(fish2)

    val fish3 = Fish("fish3")

    fish3.let { it.name }
            .let { it.toUpperCase() }
            .let { println(it) }

    val fish4 = Fish("fish4").also { it.name.toUpperCase() }
    println(fish4)

    val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    print(numbers.divisibleBy {
        it.rem(3)
    })
}

fun myWith(name: String, block: String.() -> Unit) {
    return name.block()
}

fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (block(item) == 0) {
            result.add(item)
        }
    }
    return result
}
