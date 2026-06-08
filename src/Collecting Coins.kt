import kotlin.math.floor

//Math
fun main() {
    val n = readln().trim().toInt()

    repeat(n) {
        val (a, b, c, n) = readln().trim().split(" ").map { it.toLong() }

        val A = (-2 * a + b + c + n) / 3.toDouble()


        val B = A + a - b
        val C = A + a - c

//        print("$A $B $C\n")
//        println("${A + a} ${B + b} ${C + c}")
        fun isWholeAndNonNegative(x: Double) = x >= 0 && x % 1.0 == 0.0 //floor(x)!=x

        if (listOf(A, B, C).all { isWholeAndNonNegative(it) })
            println("YES")
        else
            println("No")


    }
}