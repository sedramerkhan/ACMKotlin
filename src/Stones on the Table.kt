fun main() {

    val n = readln().trim().toInt()
    val s = readln().trim()

    println(s.zipWithNext().count { (a, b) -> a == b })

   // println(s.windowed(2).count { it[0] == it[1] })

    //println((1..<n).count { s[it] == s[it - 1] })

}