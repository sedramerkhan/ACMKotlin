fun main() {

    val t = readln().trim().toInt()
    repeat(t) {
        val n = readln().trim().toInt()
        println(if (n % 3 != 0) "First" else "Second")
    }

}