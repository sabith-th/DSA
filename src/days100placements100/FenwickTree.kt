package days100placements100

class FenwickTree(val n: Int, val arr: IntArray) {
    val bit = IntArray(n+1)

    init {
        for (i in 1..n) {
            update(i, arr[i])
        }
    }

    fun update(ind: Int, value: Int) {
        var i = ind
        while (i <= n) {
            bit[i] += value
            i = i + (i and -i)
        }
    }

    fun query(ind: Int): Int {
        var i = ind
        var ans = 0
        while (i > 0) {
            ans += bit[i]
            i = i - (i and -i)
        }
        return ans
    }

    fun rangeSum(start: Int, end: Int): Int {
        return query(end) - query(start - 1)
    }
}

fun main() {
    val n = 6
    val arr = intArrayOf(0, 3, 4, -1, -2, 5, -7)
    val test = FenwickTree(n, arr)
    println("${test.rangeSum(1, 5)} = 9")
    println("${test.rangeSum(2, 4)} = 1")
    println("${test.rangeSum(3, 5)} = 2")
    println("${test.rangeSum(1, 6)} = 2")
    println("${test.rangeSum(2, 6)} = -1")
}