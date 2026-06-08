fun main() {
    val (n, a,b,c) = readln().trim().split(" ").map { it.toInt() }

    println(cutRibbon(listOf(a,b,c),n))
}

//DP Solution
fun cutRibbon(lengths: List<Int>, originalLength: Int): Int {
    // guard: empty input or zero length
    if (lengths.isEmpty() || originalLength <= 0) return -1

    // Use a safer sentinel — Int.MIN_VALUE + 1 would overflow!
    val UNREACHABLE = Int.MIN_VALUE / 2
    val dp = IntArray(originalLength + 1) { UNREACHABLE }
    dp[0] = 0

    for (a in 1..originalLength) {
        for (l in lengths) {
            if (l <= a && dp[a - l] != UNREACHABLE)
                dp[a] = maxOf(dp[a], dp[a - l] + 1)
        }
    }
    return dp[originalLength].takeIf { it != UNREACHABLE } ?: -1
}