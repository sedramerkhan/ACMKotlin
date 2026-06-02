import kotlin.math.abs
import kotlin.math.max

fun solveNaive(a: List<Long>): Long {
    var sum = 0L
    var ans = Long.MIN_VALUE

    for (i in a.indices) {
        sum += a[i]
        var j = i + 1

        while (j <= a.lastIndex && (abs(a[j]) % 2 != abs(a[j - 1]) % 2)) {
            ans = max(ans, sum)
            sum += a[j++]
        }

        ans = max(ans, sum)
        sum = 0
    }
    return ans
}

fun slidingWindow(a: List<Long>): Long {
    var sum = a[0]
    var ans = a[0]

    for (i in 1..a.lastIndex) {
        sum = if (abs(a[i]) % 2 != abs(a[i - 1]) % 2) {
            max(sum + a[i], a[i])
        } else {
            a[i]
        }
        ans = max(ans, sum)
    }
    return ans
}

// fails in last test case
fun solveDP(a: List<Long>): Long {
    var dpEven: Long? = null
    var dpOdd: Long? = null
    var ans = a[0]

    for (v in a) {
        val isEven = abs(v) % 2 == 0L
        if (isEven) {
            dpEven = max(v, dpOdd?.plus(v) ?: v)
            ans = max(ans, dpEven!!)
        } else {
            dpOdd = max(v, dpEven?.plus(v) ?: v)
            ans = max(ans, dpOdd!!)
        }
    }
    return ans
}

fun main() {
    val t = readln().trim().toInt()
    repeat(t) {
        readln().trim().toInt()
        val a = readln().trim().split(" ").map { it.toLong() }

        println(slidingWindow(a)) // swap with solveNaive or solveDP
    }
}

/**
 * 7
 * 5
 * 1 2 3 4 5
 * 4
 * 9 9 8 8
 * 6
 * -1 4 -1 0 5 -4
 * 4
 * -1 2 4 -3
 * 1
 * -1000
 * 3
 * 101 -99 101
 * 20
 * -10 5 -8 10 6 -10 7 9 -2 -6 7 2 -4 6 -1 7 -6 -7 4 1
 *
 * answer
 * 15
 * 17
 * 8
 * 4
 * -1000
 * 101
 * 10
 */