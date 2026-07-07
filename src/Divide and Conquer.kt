

fun main(){
    val t= readln().trim().toInt()

    repeat(t) {
        val (x,y) = readln().trim().split(" ").map { it.toDouble() }

        val divide= x/y
        println(if(divide % 1 == 0.toDouble()) "Yes" else "No")
    }
}