//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val t = readln().trim().toInt()
    repeat(t) {
        val n = readln().trim().toInt()
        val a = readln().trim().split(" ").map { it.toInt() }

        val indexMin = a.indexOf(a.min())
        val sub = a.drop(indexMin)

        val isSorted = sub == sub.sorted()

        if(!isSorted)
            println(-1)

        else
            println(a.size - sub.size)
    }
}