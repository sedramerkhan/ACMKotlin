import kotlin.math.max

fun main(){

    val t = readln().trim().toInt()

    var ans = 0L
    var p = 0L
    repeat(t) {
        val (a, b) = readln().trim().split(" ").map { it.toInt() }
        p = p - a + b
        ans = max(ans, p)
    }
    println(ans)
}