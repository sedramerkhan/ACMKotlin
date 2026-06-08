

//DP
fun main() {
    val n = readln().trim().toInt()
    val a = readln().trim().split(" ").map { it.toLong() }


    val dp = MutableList(n+1) { 0L }

    dp[0] = 0


    for(i in 0..<n) {
        dp[i+1] = dp[i] +a[i]
    }
  //  println(dp)
    val aSorted = a.sorted()

    val dpSorted = MutableList(n+1) { 0L }
    dpSorted[0] = 0
    for(i in 0..<n) {
       dpSorted[i+1] = dpSorted[i] +aSorted[i]
    }
    val m = readln().trim().toInt()

    repeat(m) {
        val (type,l,r) = readln().trim().split(" ").map { it.toInt() }
        if(type ==1){
            println(dp[r]-dp[l-1])
        }else{
            println(dpSorted[r]-dpSorted[l-1])
        }
    }

}
