package HackerRank

import java.util.Scanner
import kotlin.math.ceil


// Complete the flatlandSpaceStations function below.
fun flatlandSpaceStations(n: Int, c: Array<Int>): Int {


    val cSorted =  c.sorted()


   // println(cSorted.zipWithNext())

    val middle = cSorted.zipWithNext().maxOfOrNull { (a, b) -> (b - a) / 2 } ?: 0

    return maxOf(cSorted.first(), middle, n - 1 - cSorted.last())
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nm = scan.nextLine().split(" ")

    val n = nm[0].trim().toInt()

    val m = nm[1].trim().toInt()

    val c = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = flatlandSpaceStations(n, c)

    println(result)
}
