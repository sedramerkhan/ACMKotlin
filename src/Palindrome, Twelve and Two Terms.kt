fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toLong()

        var a = n % 12
        var b = n - a

        val isPalindrome = { num: Long ->
            num.toString().let {
                it == it.reversed()
            }
        }
        while (b >= 0) {
            //  println("${a} ${b}")
            if (isPalindrome(a)) {
                println("$a $b")
                break
            } else {
                b -= 12
                a += 12
            }
        }
        if (b < 0) println("-1")
    }
}


