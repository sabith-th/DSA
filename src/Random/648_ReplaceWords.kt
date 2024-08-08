package Random

import kotlin.collections.forEach
import kotlin.collections.joinToString
import kotlin.text.split
import kotlin.text.substring

class ReplaceWords {
    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val ans = mutableListOf<String>()
        sentence.split(" ").forEach { word ->
            var temp = word
            for (root in dictionary) {
                if (word.length >= root.length && word.substring(0, root.length) == root) {
                    temp = if (temp.length > root.length) root else temp
                }
            }
            ans.add(temp)
        }
        return ans.joinToString(" ")
    }
}

fun main() {
    val test = ReplaceWords()
    println(test.replaceWords(listOf("cat","bat","rat"), "the cattle was rattled by the battery"))
}