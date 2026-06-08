
//Math
fun main() {
    val l = readln().trim().split(" ").map { it.toLong() }.sorted()

    val c = l.last() - l.first()
    val b = l[2] - c
    val a = l.first() - b


    println("$a $b $c")


}