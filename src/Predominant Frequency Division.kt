// Not solved
fun main() {

    val t = readln().trim().toInt()

    repeat(t) {
        readln()

        val a = readln().trim().split(" ").map { it.toInt() }


        var leftIndex = 0
        var countOne  = if(a[leftIndex] == 1) 1 else 0
        while (leftIndex < a.size) {
            if(countOne *2 <=leftIndex){
                leftIndex ++
                if(a[leftIndex] ==1)
                    countOne++
            }
        }
    }
}