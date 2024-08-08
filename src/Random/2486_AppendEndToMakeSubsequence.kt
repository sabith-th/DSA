package Random

class AppendEndToMakeSubsequence {
    fun appendCharacters(s: String, t: String): Int {
        var j = 0
        for (c in s) {
            if (j == t.length) {
                return 0
            }
            if (c == t[j]) {
                j++
            }
        }
        return t.length - j
    }
}