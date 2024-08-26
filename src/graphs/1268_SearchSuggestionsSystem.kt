package graphs

private class TrieNode {
    val children = Array<TrieNode?>(26) { null }
    var isWord = false
}

private class Trie {
    val root = TrieNode()

    fun addWord(word: String) {
        var curr = root
        for (c in word) {
            val index = c - 'a'
            if (curr.children[index] == null) {
                curr.children[index] = TrieNode()
            }
            curr = curr.children[index]!!
        }
        curr.isWord = true
    }

    fun findWord(curr: TrieNode, ans: MutableList<String>, sb: StringBuilder) {
        if (ans.size == 3) return
        if (curr.isWord) ans.add(sb.toString())
        for (i in 0..25) {
            if (ans.size == 3) return
            if (curr.children[i] != null) {
                sb.append('a' + i)
                findWord(curr.children[i]!!, ans, sb)
                sb.deleteAt(sb.lastIndex)
            }
        }
    }

    fun searchWords(prefix: String): List<String> {
        val ans = mutableListOf<String>()
        var curr = root
        val sb = StringBuilder()
        for (c in prefix) {
            val index = c - 'a'
            if (curr.children[index] == null) return ans
            curr = curr.children[index]!!
            sb.append(c)
        }
        findWord(curr, ans, sb)
        return ans
    }
}

class SearchSuggestionsSystem {
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        val trie = Trie()
        for (product in products) {
            trie.addWord(product)
        }
        val ans = mutableListOf<List<String>>()
        for (i in 1..searchWord.length) {
            ans.add(trie.searchWords(searchWord.substring(0, i)))
        }
        return ans
    }
}

fun main() {
    val searchSuggestionsSystem = SearchSuggestionsSystem()
    println(searchSuggestionsSystem.suggestedProducts(
        products = arrayOf("mobile","mouse","moneypot","monitor","mousepad"), searchWord = "mouse")
    )
    println(searchSuggestionsSystem.suggestedProducts(products = arrayOf("havana"), searchWord = "havana"))
}