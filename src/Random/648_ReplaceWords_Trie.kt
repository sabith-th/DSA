package Random

import java.lang.StringBuilder
import kotlin.text.split

class TrieNode {
    val children: Array<TrieNode?> = Array<TrieNode?>(26) { null }
    var word: String? = null
}

class ReplaceWords_Trie {
    private val root = TrieNode()

    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val sb = StringBuilder()

        for (word in dictionary) {
            insert(word)
        }
        for (word in sentence.split(" ")) {
            sb.append(" ").append(search(word))
        }

        return sb.substring(1).toString()
    }

    private fun insert(word: String) {
        var node: TrieNode = root
        for (c in word) {
            val i = c - 'a'
            if (node.children[i] == null) {
                node.children[i] = TrieNode()
            }
            node = node.children[i]!!
        }
        node.word = word
    }

    private fun search(word: String): String {
        var node = root
        for (c in word) {
            if (node.word != null) return node.word!!
            val i = c - 'a'
            if (node.children[i] == null) return word
            node = node.children[i]!!
        }
        return word
    }
}

fun main() {
    val test = ReplaceWords_Trie()
    println(test.replaceWords(listOf("cat","bat","rat"), "the cattle was rattled by the battery"))
}