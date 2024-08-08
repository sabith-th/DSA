package DSA

class PermutationInString {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.length < s1.length) {
            return false
        }
        val charCount = mutableMapOf<Char, Int>()
        for (c in s1) {
            charCount[c] = charCount.getOrElse(c) {0} + 1
        }
        var i = 0
        var j = 0
        val charCount2 = mutableMapOf<Char, Int>()

        while (j < s2.length) {
            while (j < s1.length) {
                charCount2[s2[j]] = charCount2.getOrElse(s2[j]) {0} + 1
                j++
            }
            var mismatch = false
            for (k in charCount.keys) {
                if (charCount.getOrDefault(k, 0) != charCount2.getOrDefault(k, 0)) {
                    mismatch = true
                    break
                }
            }
            if (!mismatch) {
                return true
            }
            charCount2[s2[i]] = charCount2.getOrDefault(s2[i], 0) - 1
            charCount2[s2[j]] = charCount2.getOrDefault(s2[j], 0) + 1
            i++
            j++
        }

        for (k in charCount.keys) {
            if (charCount.getOrDefault(k, 0) != charCount2.getOrDefault(k, 0)) {
                return false
            }
        }

        return true
    }

    fun checkInclusion2(s1: String, s2: String): Boolean {
        val count = IntArray(26)
        var required = s1.length
        for (c in s1) {
            count[c - 'a']++
        }

        var l = 0
        for (r in s2.indices) {
            if (--count[s2[r] - 'a'] >= 0) {
                --required
            }
            while (required == 0) {
                if (r-l+1 == s1.length) {
                    return true
                }
                if (++count[s2[l++] - 'a'] > 0) {
                    ++required
                }
            }
        }
        return false
    }
}

fun main() {
    val test = PermutationInString()
    println(test.checkInclusion("adc", "dcda"))
}