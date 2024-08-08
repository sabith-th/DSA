package Random

import java.util.ArrayList
import kotlin.collections.plus
import kotlin.ranges.downTo
import kotlin.text.reversed
import kotlin.text.substring

class PalindromePartitioning {

    private fun isPalindrome(s: String): Boolean {
        return s.reversed() == s
    }

    fun partition(s: String): List<List<String>> {
        if (s.length == 1) {
            return listOf(listOf(s))
        }

        val ans = ArrayList<List<String>>()
        for (i in 1..s.length) {
            val subs = s.substring(0, i)
            if (isPalindrome(subs)) {
                val temp = partition(s.substring(i, s.length))
                for (t in temp) {
                    ans.add(listOf(subs) + t)
                }
                if (s.length == subs.length) {
                    ans.add(listOf(subs))
                }
            }
        }
        return ans
    }


}

class PalindromePartitioning2 {
    private fun dfs(s: String, start: Int, partition: MutableList<String>, ans: MutableList<MutableList<String>>, dp: Array<BooleanArray>) {
        if (start == s.length) {
            ans.add(ArrayList(partition))
            return
        }
        for (end in start..<s.length) {
            if (dp[start][end]) {
                partition.add(s.substring(start, end+1))
                dfs(s, end+1, partition, ans, dp)
                partition.removeLast()
            }
        }

    }

    fun partition(s: String): List<List<String>> {
        val ans = mutableListOf<MutableList<String>>()
        val partition = mutableListOf<String>()
        val dp = Array<BooleanArray>(s.length) { BooleanArray(s.length) { true } }
        for (i in 0..<s.length) {
            dp[i][i] = true
        }
        for (i in s.length-1 downTo 0) {
            for (j in i+1..<s.length) {
                dp[i][j] = s[i] == s[j] && dp[i+1][j-1]
            }
        }
        dfs(s, 0, partition, ans, dp)
        return ans
    }
}

fun main() {
    val test = PalindromePartitioning2()
    print(test.partition("aab"))
}