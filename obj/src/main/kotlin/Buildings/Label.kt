package Buildings

fun labels() {
    loop@ for( i in 1..100) {
        for( j in 1..200  ){
            println( "($i, $j)")
            if (i >10 ) break@loop
        }
    }
}

fun main() {
    labels()
}