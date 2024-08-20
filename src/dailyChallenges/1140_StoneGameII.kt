package dailyChallenges

class StoneGameII {
    fun stoneGameII(piles: IntArray): Int {
        val n = piles.size
        val prefixSum = IntArray(n+1)
        for (i in piles.indices) {
            prefixSum[i+1] = prefixSum[i] + piles[i]
        }

        val dp = Array<IntArray>(n) { IntArray(n+1) {-1} }

        fun dfs(i: Int, m: Int): Int {
            if (2 * m >= n - i) {
                dp[i][m] = prefixSum[n] - prefixSum[i]
                return dp[i][m]
            }

            if (dp[i][m] != -1) return dp[i][m]

            var result = 0
            for (x in 1..2*m) {
                result = maxOf(result, prefixSum[n] - prefixSum[i] - dfs(i+x, maxOf(x, m)))
            }
            dp[i][m] = result
            return result
        }

        return dfs(0, 1)
    }
}

fun main() {
    val test = StoneGameII()
    println("Computed: ${test.stoneGameII(intArrayOf(2,7,9,4,4))} Expected: 10")
    println("Computed: ${test.stoneGameII(intArrayOf(1,2,3,4,5,100))} Expected: 104")
}