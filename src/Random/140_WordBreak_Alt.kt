package Random

import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import kotlin.collections.set
import kotlin.text.substring

class WordBreakAlt {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val wordSet: Set<String> = HashSet(wordDict)
        val mem: MutableMap<String, List<String>> = HashMap()
        return wordBreak(s, wordSet, mem)
    }

    private fun wordBreak(
        s: String, wordSet: Set<String>,
        mem: MutableMap<String, List<String>>
    ): List<String> {
        if (mem.containsKey(s)) return mem[s]!!

        val ans: MutableList<String> = ArrayList()

        // 1 <= prefix.length() < s.length()
        for (i in 1..<s.length) {
            val prefix = s.substring(0, i)
            val suffix = s.substring(i)
            if (wordSet.contains(prefix)) for (word in wordBreak(suffix, wordSet, mem)) ans.add("$prefix $word")
        }

        // `wordSet` contains the whole string s, so don't add any space.
        if (wordSet.contains(s)) ans.add(s)

        mem[s] = ans
        return ans
    }
}

fun main() {
    val test = WordBreakAlt()
    println(test.wordBreak("catsanddog", listOf("cat","cats","and","sand","dog")))
}