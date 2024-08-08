package DSA

class LetterCombinationOfAPhoneNumber {
    val lettersToDigits = listOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

    private fun dfs(digits: String, i: Int, path: String, ans: MutableList<String>) {
        if (i >= digits.length) {
            ans.add(path)
        } else {
            for (c in lettersToDigits[digits[i].toString().toInt()]) {
                dfs(digits, i+1, "$path$c", ans)
            }
        }
    }
    fun letterCombinations(digits: String): List<String> {
        val ans = mutableListOf<String>()
        dfs(digits, 0, "", ans)
        return ans
    }
}

fun main() {

}