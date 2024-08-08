package dailyChallenges

import java.util.PriorityQueue

class SortArrayByIncreasingFrequency {
    fun frequencySort(nums: IntArray): IntArray {
        val freqMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            freqMap.merge(num, 1, Integer::sum)
        }
        val pq = PriorityQueue<Pair<Int, Int>> { a, b -> if (a.second == b.second) b.first - a.first else a.second - b.second }

        for (k in freqMap.keys) {
            pq.offer(k to freqMap[k]!!)
        }

        val ans = IntArray(nums.size)
        var i = 0
        while (pq.isNotEmpty()) {
            val (num, freq) = pq.poll()
            repeat(freq) {
                ans[i++] = num
            }
        }

        return ans
    }
}