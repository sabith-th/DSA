package DSA

import java.util.Collections

class LongestIncreasingSubsequence {
    private fun firstGreaterEqual(A: List<Int>, target: Int): Int {
        val i = Collections.binarySearch<Int>(A, target)
        return if (i < 0) (-i-1) else i
    }

    fun lengthOfLIS(nums: IntArray): Int {
        val tails = ArrayList<Int>()
        for (num in nums) {
            if (tails.isEmpty() || tails.last() < num) {
                tails.add(num)
            } else {
                tails.set(firstGreaterEqual(tails, num), num)
            }
        }
        return tails.size
    }
}