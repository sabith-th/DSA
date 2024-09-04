package DSA

class LetterCombinationOfAPhoneNumber {
    val lettersToDigits = listOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

    private fun dfs(digits: String, i: Int, path: StringBuilder, ans: MutableList<String>) {
        if (i >= digits.length) {
            ans.add(path.toString())
        } else {
            for (c in lettersToDigits[digits[i] - '0']) {
                path.append(c)
                dfs(digits, i+1, path, ans)
                path.deleteAt(path.lastIndex)
            }
        }
    }

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        val ans = mutableListOf<String>()
        dfs(digits, 0, StringBuilder(), ans)
        return ans
    }
}

fun main() {
    val test = LetterCombinationOfAPhoneNumber()
    println("Computed: ${test.letterCombinations("23")} Expected: [ad, ae, af, bd, be, bf, cd, ce, cf]")
}