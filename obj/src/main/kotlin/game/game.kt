package game

enum class Directions {
    START, NORTH, SOUTH, EAST, WEST, END
}

class Game {
    var path = mutableListOf<Directions>(Directions.START)
    val east = { path.add(Directions.EAST) }
    val south = { path.add(Directions.SOUTH) }
    val north = { path.add(Directions.NORTH) }
    val west = { path.add((Directions.WEST)) }
    val end = {
        path.add(Directions.END)
//        path.forEach { println(it) }
//        path.clear()
//        println("Game over!")
    }

     fun move(where: () -> Boolean ) {
        where.invoke()
    }

    fun makeMove(command:String?) {
        when {
            command.equals("n") -> move(north)
            command.equals("s") -> move(south)
            command.equals("e") -> move(east)
            command.equals("w") -> move(west)
            else -> move(end)
        }
    }
}

fun main(args: Array<String>) {
    val game = Game()
    while (true) {
        print("Enter a direction: n/s/e/w: ")
        game.makeMove(readLine())
    }
}