

fun main() {
    val t = readln().trim().toInt()
    repeat(t) {
        val n = readln().trim().toInt()
        val a = readln().trim().split(" ").map { it.toLong() }

        println(a.solveOptimal())

    }

}


// Original - 2 loops + temp list
fun List<Long>.solveNaive(): Long {
    val temp = mutableListOf<Long>()
    forEachIndexed { i, v ->
        temp.add(if (v > 0 && (i == 0 || this[i - 1] > temp[i - 1])) v - 1 else v)
    }
    var ans = 0L
    temp.forEachIndexed { i, v ->
        if (i == 0) ans += v
        else if (temp[i - 1] < temp[i]) ans += v - temp[i - 1]
    }
    return ans
}

// Optimized - 1 loop, no extra memory
fun List<Long>.solveOptimal(): Long {
    var ans = 0L
    var prev = 0L
    forEachIndexed { i, v ->
        val cur = if (v > 0 && (i == 0 || this[i - 1] > prev)) v - 1 else v
        if (cur > prev) ans += cur - prev
        prev = cur
    }
    return ans
}
