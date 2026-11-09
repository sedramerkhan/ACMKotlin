package HackerRank


fun timeConversion(s: String): String {
    // Write your code here
    val time = s.substring(s.length-2)
    val t = s.substring(0,s.length-2)

    if(time == "PM")
    {
        val temp = t.substring(0,2).toInt()
        return "${if(temp<12) temp+12 else temp}${t.substring(2)}"
    }

    else if(t.startsWith("12"))

    {
        return "00${t.substring(2)}"
    }
    return t
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = timeConversion(s)

    println(result)
}
