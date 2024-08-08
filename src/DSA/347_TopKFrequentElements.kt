package DSA

import java.util.PriorityQueue

class TopKFrequentElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val countMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            countMap[num] = countMap.getOrElse(num) {0} + 1
        }
        val heap = PriorityQueue<Pair<Int, Int>> { t1: Pair<Int, Int>, t2: Pair<Int, Int> -> t2.second - t1.second }
        for (key in countMap.keys) {
            heap.add(Pair(key, countMap.getOrDefault(key, 0)))
        }
        val ans = IntArray(k)
        for (i in 0..<k) {
            ans[i] = heap.remove().first
        }
        return ans
    }
}