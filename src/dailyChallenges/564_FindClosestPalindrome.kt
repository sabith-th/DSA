package dailyChallenges

import kotlin.math.abs
import kotlin.math.pow

class FindClosestPalindrome {
    fun nearestPalindromic(n: String): String {
        val length = n.length
        val num = n.toLong()
        val palindromes = mutableSetOf<Long>()

        // Add edge cases
        palindromes.add(10.0.pow(length).toLong() + 1)
        palindromes.add(10.0.pow(length-1).toLong() - 1)

        val firstHalf = (n.substring(0, (length + 1) / 2)).toLong()
        for (i in firstHalf - 1 .. firstHalf + 1) {
            val sb = StringBuilder()
            sb.append(i)
            sb.append(StringBuilder().append(i.toString()).reverse().substring(length % 2))
            palindromes.add(sb.toString().toLong())
        }

        palindromes.remove(num)

        var closestPalindrome = -1L

        for (palindrome in palindromes) {
            if (closestPalindrome == -1L ||
                abs(num - palindrome) < abs(num - closestPalindrome) ||
                ((abs(num - palindrome) == abs(num - closestPalindrome)) && palindrome < closestPalindrome))  {
                    closestPalindrome = palindrome
            }
        }

        return closestPalindrome.toString()
    }
}

fun main() {
    val test = FindClosestPalindrome()
    println("Computed: ${test.nearestPalindromic("123")} Expected: 121")
    println("Computed: ${test.nearestPalindromic("1")} Expected: 0")
    println("Computed: ${test.nearestPalindromic("100")} Expected: 99")
    println("Computed: ${test.nearestPalindromic("10")} Expected: 9")
}