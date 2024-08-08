package Random

class ReverseString {
    fun reverseString(s: CharArray): Unit {
        var i = 0
        var j = s.size - 1
        while (i < j) {
            val temp = s[j]
            s[j--] = s[i]
            s[i++] = temp
        }
    }
}