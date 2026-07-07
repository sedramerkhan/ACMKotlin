
//Greedy

fun main(){


    val t = readln().trim().toInt()

    repeat(t) {
        readln()  // n, unused
        val s = readln().trim()
        val c = s[0]

        val lastSame = s.indexOfLast { it == c }
        val firstDiff = s.indexOfFirst { it != c }

        println(if (lastSame < firstDiff) 2 else 1)
    }
}