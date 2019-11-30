package col

fun main(args: Array<String>) {
    val fishnet = "fishnet" to "catching a fish"
    println(fishnet)
    println(fishnet.toString())
    println(fishnet.toList())
    val (tool, use) = fishnet
    println("this is a $tool for $use")

    fun getMeATool(): Pair<String, String> {
        return "fishnet" to "catching"
    }

    val (atool, ause) = getMeATool()
    println(atool)
    println(ause)
}
