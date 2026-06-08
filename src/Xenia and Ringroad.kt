

fun main() {
    val (n ,m) = readln().trim().split(" ").map { it.toLong() }
    val a = readln().trim().split(" ").map { it.toLong() }


    var ans = a[0] -1

    for (i in 1..<a.size) {
        ans += if(a[i] == a[i-1]) continue
        else if(a[i-1] > a[i]) {
            n - a[i-1] + a[i]
        }else{
            a[i] - a[i-1]
        }
    }

    println(ans)
}
