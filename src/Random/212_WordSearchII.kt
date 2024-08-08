package Random

import kotlin.to

class WordSearchII {
    class TrieNode {
        val children = Array<TrieNode?>(26) { null }
        var word: String? = null
    }

    class Trie {
        val root = TrieNode()

        fun insert(word: String) {
            var node = root
            for (c in word) {
                val i = c - 'a'
                if (node.children[i] == null) {
                    node.children[i] = TrieNode()
                }
                node = node.children[i]!!
            }
            node.word = word
        }

    }

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val trie = Trie()
        val m = board.size
        val n = board[0].size
        val dirs = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)

        for (word in words) {
            trie.insert(word)
        }

        val ans = mutableListOf<String>()

        fun dfs(i: Int, j: Int, node: TrieNode) {
            if (i < 0 || i >= m || j < 0 || j >= n) return
            if (board[i][j] == '*') return
            val c = board[i][j]
            val child = node.children[c-'a']
            if (child == null) return
            if (child.word != null) {
                ans.add(child.word!!)
                child.word = null
            }
            board[i][j] = '*'
            for ((dirX, dirY) in dirs) {
                dfs(i + dirX, j + dirY, child)
            }
            board[i][j] = c
        }

        for (i in 0..<m) {
            for (j in 0..<n) {
                dfs(i, j, trie.root)
            }
        }

        return ans
    }
}