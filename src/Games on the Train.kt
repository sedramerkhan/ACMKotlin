
fun main(){


    val t= readln().trim().toInt()

    repeat(t) {
        val n = readln().trim().toInt()
        val a = readln().trim().split(" ").map { it.toLong() }.sortedDescending()


        println(a.max() - a.min() +1)
    }
}