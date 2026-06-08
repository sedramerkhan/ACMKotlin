



fun main(){
    val n = readln().trim().toInt()
    val a = readln().trim().split(" ").map { it.toLong() }


    val m = readln().trim().toInt()
    val b = readln().trim().split(" ").map { it.toLong() }


//    val aSorted = a.sorted()
//    val bSorted = b.sorted().toMutableList()
//
//    var ans = 0
//
//    for (i in 0..<n) {
//        for(j in 0..<m){
//            if(listOf(aSorted[i],aSorted[i]+1 , aSorted[i]-1).contains(bSorted[j])){
//                bSorted[j] = -500
//                ans +=1
//                break
//            }
//        }
//    }
//
//    println(ans)


    println(countMatches(a, b))
}

fun countMatches(a: List<Long>, b: List<Long>): Int {
    val aSorted = a.sorted()
    val bSorted = b.sorted()
    val used = BooleanArray(b.size)

    var ans = 0
    var j = 0

    for (ai in aSorted) {
        while (j < bSorted.size && bSorted[j] < ai - 1) j++

        var k = j
        while (k < bSorted.size) {
            if (bSorted[k] - ai > 1) break
            if (!used[k]) {
                used[k] = true
                ans++
                break
            }
            k++
        }
    }

    return ans
}
