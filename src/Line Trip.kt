import kotlin.math.max

fun main() {

    val t = readln().trim().toInt()
    repeat(t) {
        val (n, x) = readln().trim().split(" ").map { it.toLong() }
        val a = readln().trim().split(" ").map { it.toLong() }

        var ans = ((listOf(0L) + a).zipWithNext { a, b -> b - a }).max()
        ans = max(ans, (x - a.last()) * 2)

        println(ans)
    }
}