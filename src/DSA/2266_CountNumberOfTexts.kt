package DSA

class CountNumberOfTexts {
    fun countTexts(pressedKeys: String): Int {
        val n = pressedKeys.length
        val validKeyPresses = setOf(
            "2", "22", "222", "3", "33", "333",
            "4", "44", "444", "5", "55", "555", "6", "66", "666",
            "7", "77", "777", "7777", "8", "88", "888",
            "9", "99", "999", "9999"
        )

        val dp = LongArray(n+1) { -1L }
        val mod = 1_000_000_007

        fun countWays(i: Int): Long {
            if (i >= n) return 1L
            if (i == n-1) {
                dp[i] = 1L
                return dp[i]
            }
            if (dp[i] != -1L) return dp[i]
            var j = i+1
            var numWays = 0L
            while (j <= n && pressedKeys.substring(i, j) in validKeyPresses) {
                numWays = (numWays + (countWays(j) % mod)) % mod
                j++
            }
            dp[i] = numWays
            return dp[i]
        }

        countWays(0)
        return dp[0].toInt()
    }
}

fun main() {
    val test = CountNumberOfTexts()
    println("Computed = ${test.countTexts("22233")} Expected = 8")
    println("Computed = ${test.countTexts("222222222222222222222222222222222222")} Expected = 82876089")
}