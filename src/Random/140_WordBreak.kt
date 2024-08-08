package Random

import kotlin.collections.joinToString
import kotlin.text.substring

class WordBreak {

    private fun dfs(i: Int, s: String, wordDict: List<String>, ans: ArrayList<String>, path: ArrayList<String>) {
        if (i == s.length) {
            ans.add(path.joinToString(" "))
        }

        for (j in i..<s.length) {
            val word = s.substring(i, j+1)
            if (word in wordDict) {
                path.add(word)
                dfs(j+1, s, wordDict, ans, path)
                path.removeLast()
            }
        }
    }
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val ans = java.util.ArrayList<String>()
        val path = java.util.ArrayList<String>()
        dfs(0, s, wordDict, ans, path)
        return ans
    }
}

fun main() {
    val test = WordBreak()
    println(test.wordBreak("catsanddog", listOf("cat","cats","and","sand","dog")))
}