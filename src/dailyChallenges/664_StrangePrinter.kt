package dailyChallenges

class StrangePrinter {
    fun strangePrinter(s: String): Int {
        val n = s.length
        val dp = Array<IntArray>(n) { IntArray(n) {-1} }

        fun solve(i: Int, j: Int): Int {
            if (i == j) {
                dp[i][j] = 1
                return 1
            }
            if (dp[i][j] != -1) return dp[i][j]
            var minTurns = Int.MAX_VALUE
            for (k in i..<j) {
                minTurns = minOf(minTurns, solve(i, k) + solve(k+1, j))
            }
            dp[i][j] = if (s[i]==s[j]) minTurns - 1 else minTurns
            return dp[i][j]
        }

        return solve(0, n-1)
    }
}

fun main() {
    val test = StrangePrinter()
    println("Computed: ${test.strangePrinter("aaabbb")} Expected: 2")
    println("Computed: ${test.strangePrinter("aba")} Expected: 2")
    println("Computed: ${test.strangePrinter("ababa")} Expected: 3")
    println("Computed: ${test.strangePrinter("abcdea")} Expected: 5")
}