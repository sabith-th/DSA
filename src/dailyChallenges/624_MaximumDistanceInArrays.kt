package dailyChallenges

import java.util.PriorityQueue
import kotlin.math.abs

class MaximumDistanceInArrays {
    fun maxDistance(arrays: List<List<Int>>): Int {
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        val maxHeap = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.first } )
        for (i in arrays.indices) {
            minHeap.offer(arrays[i].first() to i)
            maxHeap.offer(arrays[i].last() to i)
        }
        var maxDistance = 0
        val (maxVal, maxInd) = maxHeap.poll()
        val (minVal, minInd) = minHeap.poll()
        if (maxInd != minInd) {
            maxDistance = abs(maxVal - minVal)
        } else {
            val (secMaxVal, _) = maxHeap.poll()
            val (secMinVal, _) = minHeap.poll()
            maxDistance = maxOf(maxVal - secMinVal, secMaxVal - minVal)
        }
        return maxDistance
    }
}

fun main() {
    val test = MaximumDistanceInArrays()
    println(test.maxDistance(listOf(listOf(1,2,3),listOf(4,5),listOf(1,2,3))))
}