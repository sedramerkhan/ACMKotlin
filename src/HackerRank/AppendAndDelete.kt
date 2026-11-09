package HackerRank


fun appendAndDelete(s: String, t: String, k: Int): String {
    // Write your code here
    var c = 0

//    val common = s.commonPrefixWith(t).length

    for ((i, element) in s.withIndex())
        if(i < t.length && element == t[i])
            c++
        else break

    val ans = k - (s.length - c + t.length -c)
    return if ((ans >= 0 && ans % 2 == 0) || k >= s.length + t.length) "Yes" else "No"


}

fun main(args: Array<String>) {
    val s = readLine()!!

    val t = readLine()!!

    val k = readLine()!!.trim().toInt()

    val result = appendAndDelete(s, t, k)

    println(result)
}
