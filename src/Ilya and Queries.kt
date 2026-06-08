//DP
fun main() {

    val s = readln().trim()

    val dp = MutableList(s.length+1) { 0L }

   for(i in 0 ..<s.length -1 ){
       dp[i+1] = if(s[i]== s[i+1]) dp[i]+1 else dp[i]
      // println("${dp[i+1]} ${s[i]} ${s[i+1]}")
   }

   // println(dp)
    val m = readln().trim().toInt()
    repeat(m) {
        val (l, r) = readln().trim().split(" ").map { it.toInt() }
        println(dp[r-1] - dp[l-1])

    }

}