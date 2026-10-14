
fun main(){


    val t= readln().trim().toInt()

    repeat(t) {
        val (x, y, z) = readln().trim().split(" ").map { it.toLong() }.sorted()
        println(minOf(y - x, z - y))
    }
}