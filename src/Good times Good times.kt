
//DFS
fun main(){

    val t= readln().trim().toInt()

    val goods = mutableListOf<Long>()

    fun dfs(current: Long, digitsUsed: Int) {  // digitsUsed as a bitmask over 0..9
        if (current > 1_000_000_000L) return
        if (current >= 2) goods.add(current)

        for (d in 0..9) {
            val newMask = digitsUsed or (1 shl d)

            if (Integer.bitCount(newMask) > 2) continue
            dfs(current * 10 + d, newMask)
        }
    }

// Kick off with each non-zero leading digit:
    for (d in 1..9) dfs(d.toLong(), 1 shl d)

   // println(goods)
    repeat(t) {
        val x = readln().trim().toLong()

        for(y in goods){
            val mult= x *y
            val list =  mult.toString().map { it.digitToInt() }
            if(list.toSet().size <= 2) {
                println(y)
                break
            }
        }
    }

}