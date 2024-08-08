package DSA

import java.util.PriorityQueue

class MinCostToHireWorkers {
    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        val leftHeap = PriorityQueue<Int>()
        var rightHeap = PriorityQueue<Int>()
        var i = 0
        var j = costs.size - 1

        var totalCost: Long = 0

        repeat(k) {
            while (leftHeap.size < candidates && i <= j) {
                leftHeap.offer(costs[i++])
            }
            while (rightHeap.size < candidates && i <= j) {
                rightHeap.offer(costs[j--])
            }

            val leftMin = leftHeap.peek() ?: Int.MAX_VALUE
            val rightMin = rightHeap.peek() ?: Int.MAX_VALUE
            if (leftMin <= rightMin) {
                totalCost += leftMin
                leftHeap.poll()
            } else {
                totalCost += rightMin
                rightHeap.poll()
            }
        }

        return totalCost
    }
}