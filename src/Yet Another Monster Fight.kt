import kotlin.math.max

///NOT SOLVED
fun main() {
    val n = readln().trim().toInt()
    val a = readln().trim().split(" ").map { it.toLong() }

//    var ans = a.max()
//    val maxIndex = a.indexOf(ans)
//
//    //print("maxIndex ${maxIndex}")
//    a.forEachIndexed { index, lng ->
//
////        val dis = if (maxIndex > index) {
////            val left = maxIndex - index
////            val right = n - maxIndex + (maxIndex - index) - 1
////            max(left, right)
////        } else if (maxIndex < index) {
////            val left = maxIndex + index - maxIndex
////            val right = index - maxIndex
////            max(left, right)
////
////        } else 0
//
//
//        val dis = when {
//            index < maxIndex -> (n - 1 - maxIndex) + (maxIndex - index) // push right first
//            index > maxIndex -> maxIndex + (index - maxIndex)           // push left first
//            else -> 0
//        }
////
//        ans = max(ans, dis + lng)
//        // println("dis is $dis index is $index lng is $lng $${dis+lng}")
//    }

//    println(ans)


    val sl = mutableListOf(a[0])
    val sr = LongArray(n)

    (1..<n).forEach { p->
        sl.add( max(sl[p-1], a[p]+p+1))

    }


    (n-2 downTo 0).forEach { p->
        sr[p] = max(sr[p+1], a[p]+n-p)
    }

    var ans = Long.MAX_VALUE
    for (p in 0..<n) {
        val left  = if (p == 0)   0L else sl[p-1]
        val right = if (p == n-1) 0L else sr[p+1]
        ans = minOf(ans, maxOf(left, right, a[p]))
    }
    println(ans)

}

