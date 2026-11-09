package HackerRank

fun miniMaxSum2(arr: Array<Int>) {
    val total = arr.sumOf { it.toLong() }
    val min = total - arr.max()
    val max = total - arr.min()
    println("$min $max")
}

fun miniMaxSum(arr: Array<Int>): Unit {
    // Write your code here
    var mini = arr.sum()
    var maxi = 0
    for ( i in 0 until arr.size)
    {
        val ans = arr.withIndex().sumOf {(ind, v) -> if(ind != i) v else 0  }
        mini = ans.coerceAtMost(mini)
        maxi = ans.coerceAtLeast(maxi)
    }
    println("$mini $maxi")


}

fun main(args: Array<String>) {

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    miniMaxSum(arr)
}
