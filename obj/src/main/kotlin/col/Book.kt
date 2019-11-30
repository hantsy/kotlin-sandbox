package col

import java.util.*

const val MAX_NUMBER_BOOKS = 20

object Constants {
    const val BASE_URL = "http://www.turtlecare.net/"
}

class Book(val title: String, val author: String, val year: Int, var pages: Int = 100) {

    fun bookAuthor(): Pair<String, String> {
        return title to author
    }

    fun bookAuthorYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }

    fun canBorrow(hasBooks: Int): Boolean {
        return (hasBooks < MAX_NUMBER_BOOKS)
    }

    fun printUrl() {
        println(Constants.BASE_URL + title + ".html")
    }

    companion object {
        val BASE_URL = "http://www.turtlecare.net/"
    }

}

fun Book.weight(): Double = this.pages * 1.5
fun Book.tornPages(torn: Int) = if (pages >= torn) pages -= torn else pages = 0

class Puppy() {
    fun playWithBook(book: Book) {
        book.tornPages(Random().nextInt(12))
    }
}

fun printBook() {
    val puppy = Puppy()
    val book = Book("Oliver Twist", "Charles Dickens", 1837, 540)

    while (book.pages > 0) {
        puppy.playWithBook(book)
        println("${book.pages} left in ${book.title}")
    }
    println("Sad puppy, no more pages in ${book.title}. ")
}

fun main(args: Array<String>) {
//    val book = Book("Kotlin in action", "Manning publish", 2017)
//    val bookTitleAuthor = book.bookAuthor()
//    val bookAuthorYear = book.bookAuthorYear()
//
//    println("This book: ${bookTitleAuthor.first} by ${bookTitleAuthor.second}")
//    println("The book: ${bookAuthorYear.first} by ${bookAuthorYear.second} in ${bookAuthorYear.third} year")
//
//    val allBooks = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")
//    val library = mapOf("Shakespeare" to allBooks)
//    println(library.any { it.value.contains("Hamlet") })
//
//    val moreBooks = mutableMapOf<String, String>("Wilhelm Tell" to "Schiller")
//    moreBooks.getOrPut("Jungle Book") { "Kipling" }
//    moreBooks.getOrPut("Hamlet") { "Shakespeare" }
//    println(moreBooks)

    printBook()
}