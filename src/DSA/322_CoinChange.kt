package DSA

class CoinChange {
    private fun countCoins(coins: IntArray, amount: Int, dp: IntArray): Int {
        if (amount < 0) {
            return Int.MAX_VALUE
        } else if (amount == 0) {
            return 0
        }
        if (dp[amount] != -1) return dp[amount]
        var min = Int.MAX_VALUE
        for (coin in coins) {
            min = minOf(min, countCoins(coins, amount-coin, dp))
        }
        dp[amount] = if (min != Int.MAX_VALUE) 1+min else min
        return dp[amount]
    }

    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount+1) {-1}
        dp[0] = 0
        val ans = (countCoins(coins, amount, dp))

        return dp[amount]
    }
}

fun main() {
    val test = CoinChange()
    println(test.coinChange(intArrayOf(1, 2, 5), 11))
    println(test.coinChange(intArrayOf(2, 4), 3))
}