package exercism

object CryptoSquare {
    fun ciphertext(plaintext: String): String {
        val newString = plaintext.filter { it.isLetter() || it.isDigit() }.map { it.lowercaseChar() }
        if (newString.size <= 1) {
            return newString.joinToString("")
        }
        val c = Math.ceil(Math.sqrt(newString.size.toDouble())).toInt()
        val r = if (c * (c-1) >= newString.size) c-1 else c
        val ans = Array<StringBuilder>(c) { StringBuilder() }
        var index = 0
        for (i in 0..<r) {
            for (j in 0..<c) {
                if (index < newString.size) {
                    ans[j].append(newString[index])
                }
                index++
            }
        }
        for (i in 0..<c) {
            if (ans[i].length < r) {
                ans[i].append(" ")
            }
        }
        return ans.joinToString(" ")
    }

    fun ciphertext2(plaintext: String): String {
        if (plaintext.isEmpty()) return ""
        val onlyLettersAndNumbers = "[^a-z0-9]".toRegex()
        val normalized = plaintext.lowercase().replace(onlyLettersAndNumbers, "")
        val cols = Math.ceil(Math.sqrt(normalized.length.toDouble())).toInt()
        val chunked = normalized.chunked(cols)
        val squared = chunked.first().mapIndexed { i, _ ->
            chunked.map { row ->
                if (row.length <= i) " " else row[i]
            }.joinToString("")
        }.joinToString(" ")
        return squared
    }
}

fun main() {
    println(CryptoSquare.ciphertext("If man was meant to stay on the ground, god would have given us roots."))
    println("imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn  sseoau ")

}