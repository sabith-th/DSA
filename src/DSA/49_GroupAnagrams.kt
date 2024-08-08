package DSA

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val keyToAnagrams = mutableMapOf<String, MutableList<String>>()
    for (str in strs) {
        val chars = str.toCharArray()
        chars.sort()
        val key = chars.joinToString("")
        keyToAnagrams.getOrPut(key) { mutableListOf<String>()}.add(str)
    }
    return keyToAnagrams.values.toList()
}

fun main() {
    println(groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")))
}