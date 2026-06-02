import kotlin.collections.forEach
import kotlin.math.max

fun main (){
    val t = readln().trim().toInt()
    repeat(t) {
        val n = readln().trim().toInt()
        val a = readln().trim().split(" ").map { it.toLong() }

       val m = mutableMapOf<Long,Long>()
        var ans = 0L
        a.forEach {
            val key = max(it, 2L)
            ans += m.getOrDefault(key, 0L)
            m[key] = m.getOrDefault(key, 0L) + 1L //it-log(it) for 2 & 1 equals to 1 so that both are inserted in same map key

        }
        println("$ans")
    }
}