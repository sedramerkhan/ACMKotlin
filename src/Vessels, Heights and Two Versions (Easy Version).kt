
import kotlin.math.max
import kotlin.math.min
import kotlin.repeat

fun main() {
    val t = readln().trim().toInt()
    repeat(t) {
        val n = readln().trim().toInt()
        val b = readln().trim().split(" ").map { it.toLong() }

        val list = mutableListOf<LongArray>()

        for (i in b.indices) {
            val a = b.subList(i, n) + b.subList(0, i)
            println("aCopy ${a}")
            val temp = LongArray(n) { -1L }

            temp[0] = 0
            temp[1] = a[0]


            for (j in 2..<n) {

                // temp[j] = if (temp[j - 1] > a[j - 1]) temp[j - 1] else min(a[j],a[j-1])
                temp[j] = max(temp[j - 1], a[j - 1])
            }

            var rightMax = a[n - 1]
            temp[n - 1] = min(temp[n - 1], rightMax)
            for (j in n - 2 downTo 1) {
                rightMax = max(rightMax, a[j])
                temp[j] = min(temp[j], rightMax)
            }

            list.add(temp)
           println("----  ${temp.contentToString()}")

        }
        println(list.map { it.sum() }.joinToString(" "))



    }
}


fun solve2Pointer(a: LongArray) {
    val n = a.size
    val results = LongArray(n)

    for (i in 0 until n) {
        val L = n - 1
        val lWall = a[i]
        val rWall = a[(i - 1 + n) % n]

        // prefMaxLeft[p] = max(lWall, h_linear[0..p-1])
        // where h_linear[k] = a[(i + 1 + k) % n]
        val prefMaxLeft = LongArray(L)
        prefMaxLeft[0] = lWall
        for (p in 1 until L) {
            prefMaxLeft[p] = max(prefMaxLeft[p - 1], a[(i + p) % n])
        }

        // sufMaxRight[p] = max(h_linear[p..L-2], rWall)
        val sufMaxRight = LongArray(L)
        sufMaxRight[L - 1] = rWall
        for (p in L - 2 downTo 0) {
            sufMaxRight[p] = max(sufMaxRight[p + 1], a[(i + 1 + p) % n])
        }

        var sum = 0L
        for (p in 0 until L) {
            sum += min(prefMaxLeft[p], sufMaxRight[p])
        }
        results[i] = sum
    }

    println(results.joinToString(" "))
}

//Wrong
fun solve(a: LongArray) {

    val n = a.size
    val list = mutableListOf<LongArray>()

    for (i in a.indices) {
        val temp = LongArray(n) { -1L }
        temp[i] = 0
        if (i > 0) {
            temp[i - 1] = a[i - 1]
        }
        if (i < n - 1) {
            temp[i + 1] = a[i]
        }


        repeat(n) {
            for (j in i - 2 downTo 0) {
                temp[j] = if (temp[j + 1] > a[j])
                    temp[j + 1] else a[j]
            }
            for (j in i + 2..<n) {
                temp[j] = if (temp[j - 1] > a[j - 1]) temp[j - 1] else min(a[j], a[j - 1])
            }


            if (i < n - 2)
                temp[n - 1] = if (temp[0] > a[n - 1])
                    temp[0] else temp[n - 1]

            if (i > 1)
                temp[0] = if (temp[0] != temp[n - 1] && max(temp[0], temp[n - 1]) > a[n - 1]) a[n - 1] else temp[0]


        }

        list.add(temp)
        println(temp.contentToString())
    }
    print("Sum are ")
    println(list.map { it.sum() })

    println()

}


/*
2
4
1 2 3 4
5
5 3 1 5 2

4
4
1 2 3 4
5
5 3 1 5 2
6
3 4 2 6 1 5
7
1 2 1 4 2 3 5

output
6 6 7 9
17 16 14 14 17
21 21 20 20 21 21
17 17 17 17 21 21 22

 */