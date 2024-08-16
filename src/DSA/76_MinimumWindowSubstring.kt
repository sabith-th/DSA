package DSA

class MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {
        val charCount = IntArray(128)
        var required = t.length
        var bestLeft = -1
        var minLen = s.length + 1
        var i = 0
        var j = 0
        for (c in t) {
            charCount[c.code]++
        }
        while (j < s.length) {
            if (--charCount[s[j].code] >= 0) {
                required--
            }
            while (required == 0) {
                if (j - i + 1 < minLen) {
                    bestLeft = i
                    minLen = j - i + 1
                }
                if (++charCount[s[i++].code] > 0) {
                    required++
                }
            }
            j++
        }
        return if (bestLeft == -1) "" else s.substring(bestLeft, bestLeft + minLen)
    }
}

fun main() {
    val test = MinimumWindowSubstring()
    println(test.minWindow("ADOBECODEBANC", "ABC"))
}