package HackerRank

fun strangeCounter(t: Long): Long {
    // Write your code here

    var num = 3L
    var temp = 3L
    while(t>temp){
        num *=2
        temp +=num
    }

    val ans =t - temp+num

    //println(ans)
    return num -ans +1
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toLong()

    val result = strangeCounter(t)

    println(result)
}
