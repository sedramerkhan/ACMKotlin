

fun main() {

    val t = readln().trim().toInt()

    repeat(t) {
        readln()

        val a = readln().trim().split(" ").map { it.toLong() }


        println(if (a.count { it >= 3L } > 0 || a.count { it == 2L } > 1) "Yes" else "No")

    }
}
