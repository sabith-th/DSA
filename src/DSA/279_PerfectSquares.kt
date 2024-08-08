package DSA

class PerfectSquares {
    fun numSquares(n: Int): Int {
        val dp = IntArray(n+1) { n }
        dp[0] = 0
        dp[1] = 1
        for (i in 2..n) {
            var j = 1
            while (j * j <= i) {
                dp[i] = minOf(dp[i], dp[i - j * j] + 1)
                j++
            }
        }
        return dp[n]
    }
}

fun main() {
    val test = PerfectSquares()
//    println(test.numSquares(1))
    println(test.numSquares(3))
    println(test.numSquares(5))
}