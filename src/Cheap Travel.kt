import kotlin.math.ceil


fun main() {
    val (n, m, a, b) = readln().trim().split(" ").map { it.toLong() }

    //val ans = minOf(n*a, (n/m)*b + (n%m)*a, ceil(((n.toDouble()/m)) *b ).toLong())

    val ceilDiv = (n + m - 1) / m   // ceil(n/m) without any floating point
    val ans = minOf(n * a, (n / m) * b + (n % m) * a, ceilDiv * b)
    println(ans)


}
