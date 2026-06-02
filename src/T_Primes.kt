import kotlin.math.sqrt

fun main(){
    val n= readln().trim().toInt()
    val a = readln().trim().split(" ").map { it.toLong() }
    for (i in 0 ..<n){
        println(if(isTPrime(a[i])) "YES" else "NO")
    }

}

private fun isPrime(n: Long): Boolean {
    if (n < 2) return false
    if (n == 2L) return true
    if (n % 2 == 0L) return false
    var i = 3L
    while (i * i <= n) {
        if (n % i == 0L) return false
        i += 2
    }
    return true
}

private fun isTPrime(n: Long): Boolean {
    val sq = sqrt(n.toDouble())
    if(sq.toLong() * sq.toLong() != n) return false
    return isPrime(sq.toLong())
}