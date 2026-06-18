
import kotlin.math.min
import kotlin.repeat


fun main() {

    val t = readln().trim().toInt()

    repeat(t) {
        val n = readln().trim().toInt()

        val a = readln().trim().split(" ").map { it.toLong() }


        val ans = LongArray(n) { -1L}

        ans[0]= a[0]
        var prefixSum = a[0]
        for(i in 1..<n){
            prefixSum += a[i]
            ans[i] = min(prefixSum / (i + 1),  ans[i - 1])

        }

        println(ans.joinToString(" "))

    }
}