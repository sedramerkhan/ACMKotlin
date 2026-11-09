package HackerRank

fun String.allIndicesOf(sub: String): List<Int> {
    val result = mutableListOf<Int>()
    var idx = indexOf(sub)
    while (idx != -1) {
        result.add(idx)
        idx = indexOf(sub, idx + 1)
    }
    return result
}

fun gridSearch(G: Array<String>, P: Array<String>): String {
    // Write your code here
//    var exist = false
//
//   for (i in G.indices) {
//
//       for ( index in G[i].allIndicesOf(P[0])) {
//           if (index != -1) {
//               for (j in 1..<P.size) {
//                   if (i + j < G.size && G[i + j].indexOf(P[j]) == index) {
//                       exist = true
//                   } else {
//                       exist = false
//                       break
//                   }
//               }
//           }
//           if(exist) break
//       }
//
//   }
//    return  if(exist) "YES" else "NO"

    for (i in 0..G.size - P.size) {
        for (index in G[i].allIndicesOf(P[0])) {
            if (P.indices.all { j -> G[i + j].startsWith(P[j], index) }) {
                return "YES"
            }
        }
    }
    return "NO"
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val first_multiple_input = readln().trimEnd().split(" ")

        val R = first_multiple_input[0].toInt()

        val C = first_multiple_input[1].toInt()

        val G = Array<String>(R, { "" })
        for (i in 0 until R) {
            val GItem = readLine()!!
            G[i] = GItem
        }

        val second_multiple_input = readLine()!!.trimEnd().split(" ")

        val r = second_multiple_input[0].toInt()

        val c = second_multiple_input[1].toInt()

        val P = Array<String>(r, { "" })
        for (i in 0 until r) {
            val PItem = readLine()!!
            P[i] = PItem
        }

        val result = gridSearch(G, P)

        println(result)
    }
}