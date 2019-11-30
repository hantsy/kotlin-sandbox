package spices

sealed class Spice(val name: String,
                     val spiciness: String = "mild",
                     color: SpiceColor) :
        SpiceColor by color {

    abstract fun prepareSpice()
}
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val color: Color
}

object YellowSpiceColor : SpiceColor {
    override val color = Color.GREEN
}

class Curry(name: String, spiciness: String, color: SpiceColor = YellowSpiceColor) : Spice(name, spiciness, color),
        Grinder {
    override fun prepareSpice() {
        println("prepare spice")
    }

    override fun grind() {
        println("grind()")
    }
}

data class SpiceContainer(var spice: Spice) {
    val label = spice.name
}

fun printSpices() {
    val spiceCabinet = listOf(SpiceContainer(Curry("Yellow Curry", "mild")),
            SpiceContainer(Curry("Red Curry", "medium")),
            SpiceContainer(Curry("Green Curry", "spicy")))

    for(element in spiceCabinet) println(element.label)
}

fun main() {
    val curry = Curry("curry", "mild")
    println("Curry color: ${curry.color}")

    printSpices()
}