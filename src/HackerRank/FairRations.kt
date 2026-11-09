package HackerRank

fun fairRations(B: Array<Int>): String {
    // Write your code here

    val b = B.toMutableList()
    var an = 0
    for(i in b.indices) {

        if(b[i]%2 == 1 && i< b.lastIndex) {
            b[i] = b[i]+1
            b[i+1]= b[i+1]+1
            an+=2
        }
      //  println(b)
    }

    var ans = b.count { it%2 ==1 }
    return if(ans>0 ) "NO" else "$an"

//    return if(ans%2 == 1 ) "NO" else {
//        ans = 0
//        var i =1
//        while (i < B.size-1){
//            if(B[i]%2 == 1 && B[i-1]%2 == 1) {
//                ans+=2
//                i++
//            }else if(B[i]%2 == 0 && B[i-1]%2 == 1 && B[i+1]%2 == 1){
//                println("${B[i+1]} ${B[i]} ${B[i-1]}")
//                ans+=4
//                i++
//            }
//            i++
//        }
//
//        "${ans}"
//    }
}

fun main(args: Array<String>) {
    val N = readLine()!!.trim().toInt()

    val B = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = fairRations(B)

    println(result)
}
