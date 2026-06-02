import kotlin.math.max

fun main() {
    val t = readln().trim().toInt()
    repeat(t) {
        val n = readln().trim().toInt()
        val a = readln().trim().split(" ").map { it.toLong() }

      //  println(a.maxTruckDiffNaive())   // O(n²)
        println(a.maxTruckDiffOptimal()) // O(n√n)
    }
}

// O(n²) - original solution
private fun List<Long>.maxTruckDiffNaive(): Long {
    val n = size
    var ans = 0L
    for (k in 1..n) {
        if (n % k == 0) {
            val chunks = chunked(k)
            if (chunks.size > 1) {
                ans = max(ans, chunks.maxOf { it.sum() } - chunks.minOf { it.sum() })
            }
        }
    }
    return ans
}

// O(n√n) - optimized with prefix sums + divisors
private fun List<Long>.maxTruckDiffOptimal(): Long {
    val n = size
    val prefix = prefixSums()
    var ans = 0L
    for (k in divisors(n)) {
        if (k == n) continue
        var maxSum = Long.MIN_VALUE
        var minSum = Long.MAX_VALUE
        var i = 0
        while (i < n) {
            val sum = prefix[i + k] - prefix[i]
            if (sum > maxSum) maxSum = sum
            if (sum < minSum) minSum = sum
            i += k
        }
        ans = max(ans, maxSum - minSum)
    }
    return ans
}

private fun List<Long>.prefixSums(): LongArray {
    val prefix = LongArray(size + 1)
    for (i in indices) prefix[i + 1] = prefix[i] + this[i]
    return prefix
}

private fun divisors(n: Int): List<Int> {
    val result = mutableListOf<Int>()
    var i = 1
    while (i * i <= n) {
        if (n % i == 0) {
            result.add(i)
            if (i != n / i) result.add(n / i)
        }
        i++
    }
    return result
}