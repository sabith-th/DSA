package DSA

import java.util.PriorityQueue

class FindKPairsWithSmallestSums {
    class NumPair(val i: Int, val j: Int, val sum: Int): Comparable<NumPair> {
        override fun compareTo(other: NumPair): Int = sum - other.sum
    }

    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        val minHeap = PriorityQueue<NumPair>()

        for (i in nums1.indices) {
            if (minHeap.size  == k) break
            minHeap.offer(NumPair(i, 0, nums1[i] + nums2[0]))
        }

        while (minHeap.isNotEmpty() && ans.size < k) {
            val numPair = minHeap.poll()
            ans.add(listOf(nums1[numPair.i], nums2[numPair.j]))
            if (numPair.j + 1 < nums2.size) {
                minHeap.offer(NumPair(numPair.i, numPair.j + 1, nums1[numPair.i] + nums2[numPair.j + 1]))
            }
        }

        return ans
    }
}

fun main() {
    val test = FindKPairsWithSmallestSums()
    println(test.kSmallestPairs(nums1 = intArrayOf(1,7,11), nums2 = intArrayOf(2,4,6), k = 3))
    println(test.kSmallestPairs(nums1 = intArrayOf(1,1,2), nums2 = intArrayOf(1,2,3), k = 2))
    println(test.kSmallestPairs(nums1 = intArrayOf(1,2,4,5,6), nums2 = intArrayOf(3,5,7,9), k = 3))
}