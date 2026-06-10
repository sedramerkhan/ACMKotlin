fun main(){

    val t= readln().trim().toInt()

    repeat(t){
        val n = readln().trim().toInt()
        val a = readln().trim().split(" ").map { it.toLong() }.sortedDescending()

        val invalid = (0..a.size - 3).any { i -> a[i] % a[i + 1] != a[i + 2] }

        println(if (invalid) "-1" else "${a[0]} ${a[1]}")

    }
}