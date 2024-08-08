package days100placements100

class WordBreakII {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val dp = Array<IntArray>(s.length) { IntArray(wordDict.size) { - 1 } }
        val ans = mutableListOf<String>()
        val path = mutableListOf<String>()

        fun helper(i: Int) {
            if (i >= s.length) {
                ans.add(path.joinToString(" "))
                return
            }
            val substr = s.substring(i)
            for (j in wordDict.indices) {
                if (dp[i][j] != -1) {
                    if (dp[i][j] > 0) {
                        path.add(wordDict[j])
                        helper(i + wordDict[j].length)
                        path.removeLast()
                    }
                    else continue
                }
                if (substr.startsWith(wordDict[j])) {
                    path.add(wordDict[j])
                    helper(i+wordDict[j].length)
                    dp[i][j] = 1
                    path.removeLast()
                } else {
                    dp[i][j] = 0
                }
            }
        }

        helper(0)

        return ans
    }
}