package days100placements100

class KthFactor {
    fun kthFactor(n: Int, k: Int): Int {
        var count = 0
        var i = 1
        while (i <= n) {
            if (n%i == 0 && ++count==k) {
                return i
            }
//            if (i * i > n) break
            i++
        }
        return -1
    }
}

fun main() {
    val test = KthFactor()
    println(test.kthFactor(7, 2))
}