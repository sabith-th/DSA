package DSA

import java.util.PriorityQueue

class LastStoneWeight {
    fun lastStoneWeight(stones: IntArray): Int {
        val pq = PriorityQueue<Int>(reverseOrder<Int>())
        for (stone in stones) {
            pq.add(stone)
        }
        while (pq.size > 1) {
            val s1 = pq.remove()
            val s2 = pq.remove()
            if (s1 != s2) {
                pq.add(s1 - s2)
            }
        }
        return pq.lastOrNull()?: 0
    }
}