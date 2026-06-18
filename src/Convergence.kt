import kotlin.math.max


fun main(){

    val t = readln().trim().toInt()

    repeat(t){
        val n = readln().trim().toInt()

        val a= readln().trim().split(" ").map { it.toLong() }

        val aSorted= a.sorted()

        if(n==1)
            println(0)
        else{
            val midIndex= if(n%2==0) n/2 else (n-1)/2
            val mid =  aSorted[midIndex]
            val leftCount= aSorted.subList(0,midIndex).count { it!=mid }
            val rightCount= aSorted.subList(midIndex,n).count { it!=mid }
            println(max(leftCount,rightCount))
        }
    }
}