package DSA

class TrieNode() {
    val children = Array<TrieNode?>(26) { null }
    var isWord = false
}
class Trie() {
    private val root = TrieNode()

    fun insert(word: String) {
        var curr = root
        for (c in word) {
            val i = c - 'a'
            if (curr.children[i] == null) {
                curr.children[i] = TrieNode()
            }
            curr = curr.children[i]!!
        }
        curr.isWord = true
    }

    fun search(word: String): Boolean {
        val node = find(word)
        return node != null && node.isWord
    }

    fun startsWith(prefix: String): Boolean {
        return find(prefix) != null
    }

    fun find(prefix: String): TrieNode? {
        var curr = root
        for (c in prefix) {
            val i = c - 'a'
            if (curr.children[i] == null) {
                return null
            }
            curr = curr.children[i]!!
        }
        return curr
    }
}