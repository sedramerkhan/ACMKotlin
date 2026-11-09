package HackerRank

fun happyLadybugs(b: String): String {
    // Write your code here

    var areHappy = false
    if(b.contains('_')){
       val unique = b.replace("_","").toSet()

       areHappy =  unique.all { c ->
           val count = b.count { it == c }
        //   println("$c $count")
           count >1 }
    }else {

            var i = 1
            areHappy = true
            while (i < b.length - 1) {
                if (b[i] == b[i + 1] || b[i]==b[i-1]) {
                    i += 1
                } else {
                    areHappy = false
                    break
                }

            }

        if(b.length>2) {
            if(b[0] != b[1]) areHappy = false
            if (b[b.length - 2] != b[b.length - 1]) areHappy = false
        }


    }
    return if(areHappy) "YES" else "NO"
}

fun main(args: Array<String>) {
    val g = readLine()!!.trim().toInt()

    for (gItr in 1..g) {
        val n = readLine()!!.trim().toInt()

        val b = readLine()!!

        val result = happyLadybugs(b)

        println(result)
    }
}
