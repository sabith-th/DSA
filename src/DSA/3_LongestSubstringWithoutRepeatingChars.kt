package DSA

class LongestSubstringWithoutRepeatingChars {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length < 2) {
            return s.length
        }
        val seen = mutableSetOf<Char>()
        var ans = 0
        var start = 0
        var end = start + 1
        seen.add(s[0])
        while (end < s.length) {
            if (s[end] in seen) {
                while ((seen.contains(s[end])) && (start < end)) {
                    seen.remove(s[start])
                    start++
                }
                seen.add(s[end])
            } else {
                seen.add(s[end])
                ans = maxOf(ans, seen.size)
            }
            end++
        }
        ans = maxOf(ans, seen.size)
        return ans
    }
}

fun main() {
    val test = LongestSubstringWithoutRepeatingChars()
    println(test.lengthOfLongestSubstring("pwwkew"))
}