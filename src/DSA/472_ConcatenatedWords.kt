package DSA

class ConcatenatedWords {
    fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
        val wordSet = mutableSetOf<String>()
        words.forEach {
            wordSet.add(it)
        }
        val dp = mutableMapOf<String, Boolean>()

        fun isConcatenatedWord(word: String): Boolean {
            if (dp.containsKey(word)) {
                return dp[word]!!
            }
            for (i in 1..<word.length) {
                val suffix = word.substring(0, i)
                val prefix = word.substring(i, word.length)
                if (suffix in wordSet && (prefix in wordSet || isConcatenatedWord(prefix))) {
                    dp[word] = true
                    return true
                }
            }
            dp[word] = false
            return false
        }

        val ans = mutableListOf<String>()
        for (word in words) {
            if (isConcatenatedWord(word)) {
                ans.add(word)
            }
        }
        return ans
    }
}

fun main() {
    val test = ConcatenatedWords()
    println(test.findAllConcatenatedWordsInADict(arrayOf("cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat")))
}