import kotlin.math.max

// Wrong Answer ( Not Solved)
fun main() {

    val t = readln().trim().toInt()

    repeat(t) {
        val (n, x, s) = readln().trim().split(" ").map { it.toInt() } //x is number od tables , s is number of seats on each table
        val a = readln().trim()
        // dp[i][j] = max people seated considering first i people, with j non-empty tables
        val dp = Array(n + 1) { LongArray(x + 1) { -1L } }

        dp[0][0] = 0  // before processing anyone, 0 non-empty tables, 0 seated

        for(i in 0 ..<n)
        {
            for(j in 0 ..x){

                if(i==0 && j==0) continue
                val num =if(i==0 ) {
                    if (a[i] == 'I' || a[i] == 'A') dp[i][j]++
                    else 0
                }
                    else if(a[i] =='E'){
                     if(j>0) dp[i-1][j]+1 else dp[i-1][j]
                } else if(a[i] == 'I'){
                     if(j==0)  dp[i-1][j]+1 else if(j!=s) dp[i-1][j-1]+1 else dp[i-1][j]
                }else{
                    if(j==0)  dp[i-1][j]+1 else  max(dp[i-1][j-1]+1,dp[i-1][j])

                }
                dp[i][j] = max(dp[i][j],num)
            }
        }
        println(dp.map { it.max() }.max())
    }
}

fun checkPersonSeat(seats: LongArray, a: String, i: Int, s: Long): Boolean {
    val emptyTables = seats.count { it == s }
    val nonEmptyTables = seats.count { it in 1..<s }
    val remainingI = a.substring(i).count { it == 'I' }
    val remainingE = a.substring(i + 1).count { it == 'E' }

    val index = when (a[i]) {
        'I' -> seats.indexOfFirst { it == s }
        'E' -> seats.indexOfFirst { it in 1..<s }
        else -> {
            val preferEmpty = remainingI < emptyTables
            if (preferEmpty) {
                seats.indexOfFirst { it == s }.takeIf { it != -1 }
                    ?: seats.indexOfFirst { it in 1 until s }
            } else {
                seats.indexOfFirst { it in 1 until s }.takeIf { it != -1 }
                    ?: seats.indexOfFirst { it == s }
            }
        }
    }

    return (index != -1).also { if (it) seats[index]-- }
}

fun checkPersonSeatDP(seats: LongArray, c: Char, s: Long): Pair<Boolean, LongArray> {
    val seatsCopy = seats.copyOf()
    val index = when (c) {
        'A' -> seatsCopy.indexOfFirst { it > 0L }
        'E' -> seatsCopy.indexOfFirst { it != s && it > 0 }
        else -> seatsCopy.indexOfFirst { it == s }
    }
    return if (index != -1) {
        seatsCopy[index]--
        Pair(true, seatsCopy)
    } else {
        Pair(false, seatsCopy)
    }
}
