package dailyChallenges

class SumOfPrefixScores {
    class TrieNode {
        val children = Array<TrieNode?>(26) { null }
        var count = 0
    }

    class Trie {
        private val root = TrieNode()

        fun insert(word: String) {
            var curr = root
            for (c in word) {
                val i = c - 'a'
                if (curr.children[i] == null) {
                    curr.children[i] = TrieNode()
                }
                curr = curr.children[i]!!
                curr.count++
            }
        }

        fun getScore(word: String): Int {
            var curr = root
            var score = 0
            for (c in word) {
                curr = curr.children[c-'a']!!
                score += curr.count
            }
            return score
        }
    }

    fun sumPrefixScores(words: Array<String>): IntArray {
        val trie = Trie()
        val ans = IntArray(words.size)

        for (word in words) {
            trie.insert(word)
        }

        for (i in words.indices) {
            ans[i] = trie.getScore(words[i])
        }

        return ans
    }

}

fun main() {
    val test = SumOfPrefixScores()
    assert(intArrayOf(5,4,3,2) contentEquals test.sumPrefixScores(arrayOf("abc","ab","bc","b")))
}