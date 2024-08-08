package days100placements100

class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = Array<IntArray>(s.length) { IntArray(wordDict.size) { - 1 } }

        fun helper(i: Int): Boolean {
            if (i == s.length) return true
            val substr = s.substring(i)
            for (j in wordDict.indices) {
                if (dp[i][j] != -1) {
                    if (dp[i][j] > 0) return true
                    else continue
                }
                if (substr.startsWith(wordDict[j])) {
                    val valid = helper(i+wordDict[j].length)
                    if (valid) {
                        dp[i][j] = 1
                        return true
                    } else {
                        dp[i][j] = 0
                    }
                } else {
                    dp[i][j] = 0
                }
            }
            return false
        }

        return helper(0)
    }
}