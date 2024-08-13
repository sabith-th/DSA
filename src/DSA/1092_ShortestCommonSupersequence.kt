package DSA

class ShortestCommonSuperSequence {
    fun shortestCommonSupersequence(str1: String, str2: String): String {
        val m = str1.length
        val n = str2.length
        val dp = Array<IntArray>(m+1) { IntArray(n+1) }
        for (i in 1..m) {
            for (j in 1..n) {
                if (str1[i-1] == str2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1]
                } else {
                    dp[i][j] = maxOf(dp[i-1][j], dp[i][j-1])
                }
            }
        }
        val ans = StringBuilder()
        var i = m
        var j = n
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i-1][j]) {
                ans.append(str1[--i])
            } else if (dp[i][j] == dp[i][j-1]) {
                ans.append(str2[--j])
            } else {
                ans.append(str1[--i])
                j--
            }
        }
        while (i > 0) {
            ans.append(str1[--i])
        }
        while (j > 0) {
            ans.append(str2[--j])
        }
        return ans.reverse().toString()
    }
}

fun main() {
    val test = ShortestCommonSuperSequence()
    println(test.shortestCommonSupersequence("abac", "cab"))
}