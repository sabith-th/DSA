package DSA

class SubstringConcatenationOfAllWords {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val wordCount = mutableMapOf<String, Int>()
        val windowSize = words.size * words[0].length
        val wordLen = words[0].length
        val ans = mutableListOf<Int>()
        for (word in words) {
            wordCount.merge(word, 1, Int::plus)
        }
        var i = 0
        while (i <= s.length - windowSize) {
            val seen = mutableMapOf<String, Int>()
            var found = 0
            while (found < words.size) {
                var currWord = s.substring(i + wordLen * found, i + wordLen * (found+1))
                seen.merge(currWord, 1, Int::plus)
                if (seen.getOrDefault(currWord, 0) > wordCount.getOrDefault(currWord, 0)) {
                    break
                }
                found++
            }
            if (found == words.size) {
                ans.add(i)
            }
            i++
        }
        return ans
    }
}

fun main() {
    val test = SubstringConcatenationOfAllWords()
    println(test.findSubstring("wordgoodgoodgoodbestword", arrayOf("word","good","best","good")))
    println(test.findSubstring("barfoothefoobarman", arrayOf("foo","bar")))
    println(test.findSubstring("wordgoodgoodgoodbestword", arrayOf("word","good","best","word")))
    println(test.findSubstring("barfoofoobarthefoobarman", arrayOf("bar","foo","the")))
}