package days100placements100

class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        val dp = Array<IntArray>(1010) { IntArray(1010) {-1} }

        var maxLen = Int.MIN_VALUE
        var startingIndex = 0

        for (i in 0..<s.length) {
            dp[i][i] = 1
        }

        fun solve(i: Int, j: Int): Boolean {
            if (i >= j) return true
            if (dp[i][j] != -1) return dp[i][j] > 0
            if (s[i] == s[j]) {
                if (solve(i+1, j-1)) {
                    dp[i][j] = 1
                } else {
                    dp[i][j] = 0
                }
                return dp[i][j] > 0
            }
            dp[i][j] = 0
            return false
        }

        for (i in 0..<s.length) {
            for (j in i..<s.length) {
                if (solve(i, j)) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1
                        startingIndex = i
                    }
                }
            }
        }

        return s.substring(startingIndex, startingIndex+maxLen)
    }

    fun longestPalindrome2(s: String): String {
        var ans = s.substring(0, 1)

        fun expand(l: Int, r: Int): String {
            var left = l
            var right = r
            while (left >= 0 && right < s.length && s[left] == s[right]) {
                left--
                right++
            }
            return s.substring(left + 1, right)
        }

        for (i in 0..<s.length) {
            var oddStr = expand(i, i)
            var evenStr = expand(i, i+1)
            if (oddStr.length > ans.length) {
                ans = oddStr
            }
            if (evenStr.length > ans.length) {
                ans = evenStr
            }
        }

        return ans
    }
}

fun main() {
    val test = LongestPalindromicSubstring()
    println(test.longestPalindrome2("babad"))
}