package Random

import kotlin.math.abs

class EqualSubstringWithinBudget {
    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        val cost = IntArray(s.length) { 0 }
        for (i in s.indices) {
            if (s[i] != t[i]) {
                cost[i] = abs(s[i].code - t[i].code)
            }
        }

        var ans = 0
        var currCost = 0
        var i = 0
        var j = 0
        while (j < s.length) {
            if (s[j] == t[j]) {
                ans = maxOf(ans, j - i + 1)
                j += 1
            } else {
                val c = cost[j]
                if (currCost + c > maxCost) {
                    ans = maxOf(ans, j - i)
                    currCost -= cost[i]
                    i += 1
                } else {
                    currCost += c
                    j += 1
                }
            }
        }

        return maxOf(ans, j - i)
    }
}

fun main() {
    val test = EqualSubstringWithinBudget()
    println(test.equalSubstring("tyiraojpcfuttwblehv", "stbtakjkampohttraky", 119))
}