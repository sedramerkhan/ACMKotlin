
//Strings
fun main(){

    val n = readln().trim().toInt()
    repeat(n) {
        val s = readln().trim()
        println(minCost(s))
    }
}

fun minCost(s: String): Int {
    var cnt0 = s.count { it == '0' }
    var cnt1 = s.count { it == '1' }

    var tLen = 0
    for (c in s) {
        val need = if (c == '0') '1' else '0'  // t[i] must differ from s[i]
        if (need == '1' && cnt1 > 0) {
            cnt1--
            tLen++
        } else if (need == '0' && cnt0 > 0) {
            cnt0--
            tLen++
        }
        // else we can't place anything, stop extending t
        else break
    }

    return s.length - tLen
}

//Wrong
fun swipeAndDelete(s: CharArray): Int{
    //val t = mutableListOf<Char>()
    var swapped = 0
    val ss = s.copyOf()

    val t = CharArray(s.size){ ' '}
    for(i in s.indices){
        for(j in i+1..<s.size){
            //   println("${s[i]} ${s[j]}")
            if(s[i]!=s[j] && s[j]!= ' ' && s[i]!=' '){
                swapped+=2
                t[i] = s[j]
                t[j] = s[i]
                s[j] = ' '

                break
            }
        }
    }
    val filteredT= t.filter { it!=' ' }
    var deleted = 0
    for(i in filteredT.indices) {
        if(filteredT[i] == ss[i])
            deleted+=1
    }
//    println(filteredT)
//    println("swapped $swapped")
//    println("deleted $deleted")
    return s.size - swapped +deleted
}
