package Random

import kotlin.collections.set

class LongestPalindrome {
    fun longestPalindrome(s: String): Int {
        val charMap = mutableMapOf<Char, Int>()
        for (c in s) {
            charMap[c] = charMap.getOrDefault(c, 0) + 1
        }
        var odd = 0
        var ans = 0
        for ((k, v) in charMap) {
            ans += if (v % 2 == 0) v else v-1
            if (v % 2 == 1) {
                odd++
            }
        }

        ans = if (odd > 0) ans + 1 else ans
        return ans
    }
}