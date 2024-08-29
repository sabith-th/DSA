package DSA

class DecodeString {
    var i = 0

    fun decodeString(s: String): String {
        val sb = StringBuilder()

        while (i < s.length && s[i] != ']') {
            if (s[i].isDigit()) {
                var k = 0
                while (i < s.length && s[i].isDigit()) {
                    k = k * 10 + (s[i++] - '0')
                }
                i++
                val decoded = decodeString(s)
                i++
                repeat(k) {
                    sb.append(decoded)
                }
            } else {
                sb.append(s[i++])
            }
        }
        return sb.toString()
    }
}

fun main() {
    var test = DecodeString()
    println("Computed: ${test.decodeString("3[a]2[bc]")} Expected: aaabcbc")
    test = DecodeString()
    println("Computed: ${test.decodeString("3[a2[c]]")} Expected: accaccacc")
    test = DecodeString()
    println("Computed: ${test.decodeString("2[abc]3[cd]ef")} Expected: abcabccdcdcdef")
}