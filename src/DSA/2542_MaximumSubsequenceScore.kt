package DSA

import java.util.PriorityQueue

class MaximumSubsequenceScore {
    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val combined = mutableListOf<Pair<Int, Int>>()
        for (i in nums1.indices) {
            combined.add(Pair(nums2[i], nums1[i]))
        }
        combined.sortByDescending { it.first }
        val minHeap = PriorityQueue<Int>()
        var sum = 0L
        var ans = 0L
        for (i in combined.indices) {
            sum += combined[i].second
            minHeap.offer(combined[i].second)
            if (minHeap.size == k) {
                ans = maxOf(ans, sum * combined[i].first)
                sum -= minHeap.poll()
            }
        }
        return ans
    }
}

fun main() {
    val test = MaximumSubsequenceScore()
    println("Computed: ${test.maxScore(intArrayOf(1,3,3,2), intArrayOf(2,1,3,4), 3)} Expected: 12")
    println("Computed: ${test.maxScore(intArrayOf(4,2,3,1,1), intArrayOf(7,5,10,9,6), 1)} Expected: 30")
}