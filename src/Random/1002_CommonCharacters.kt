package Random
import java.util.*
import kotlin.math.min

class CommonCharacters {
    fun commonChars(words: Array<String>): List<String> {
        val charMap = mutableMapOf<Char, Int>()
        for (c in words.first()) {
            charMap[c] = charMap.getOrDefault(c, 0) + 1
        }
        for (i in 1..<words.size) {
            val word = words[i]
            val charMap2 = mutableMapOf<Char, Int>()
            for (c in word) {
                charMap2[c] = charMap2.getOrDefault(c, 0) + 1
            }
            for (k in charMap.keys) {
                if (k in charMap2.keys) {
                    charMap[k] = minOf(charMap.getOrDefault(k, 0), charMap2.getOrDefault(k, 0))
                } else {
                    charMap[k] = 0
                }
            }
        }

        val ans = ArrayList<String>()
        for (k in charMap.keys) {
            for (i in 1..charMap[k]!!) {
                ans.add(i.toString())
            }
        }
        return ans
    }

    fun commonChars2(words: Array<String>): List<String> {
        val ans: MutableList<String> = ArrayList()
        val commonCount = IntArray(26)
        Arrays.fill(commonCount, Int.MAX_VALUE)

        for (a in words) {
            val count = IntArray(26)
            for (c in a.toCharArray()) ++count[c.code - 'a'.code]
            for (i in 0..25) commonCount[i] = min(commonCount[i].toDouble(), count[i].toDouble()).toInt()
        }


        var c = 'a'
        while (c <= 'z') {
            for (i in 0..<commonCount[c.code - 'a'.code]) ans.add(c.toString())
            ++c
        }


        return ans
    }
}