package HackerRank

fun cavityMap(grid: Array<String>): Array<String> {
    // Write your code here


    val n = grid.size
    val result = grid.map { it.toCharArray() }

    for (i in 1..<n - 1) {
        for (j in 1..<n - 1) {
            val c = grid[i][j]
            if (c > grid[i - 1][j] && c > grid[i + 1][j] &&
                c > grid[i][j - 1] && c > grid[i][j + 1]) {
                result[i][j] = 'X'
            }
        }
    }
    return result.map { String(it) }.toTypedArray()
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val grid = Array<String>(n, { "" })
    for (i in 0 until n) {
        val gridItem = readLine()!!
        grid[i] = gridItem
    }

    val result = cavityMap(grid)

    println(result.joinToString("\n"))
}