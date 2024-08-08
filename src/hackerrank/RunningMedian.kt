package hackerrank

import java.text.DecimalFormat
import java.util.PriorityQueue

class RunningMedian {
    fun runningMedian(a: Array<Int>): Array<Double> {
        // Write your code here
        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int>( compareByDescending { it })
        val ans = Array<Double>(a.size) { 0.0 }
        val decimalFormat = DecimalFormat("#.#")
        for (i in a.indices) {
            val num = a[i]
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num)
            } else {
                minHeap.offer(num)
            }

            // Balance the heaps
            if (maxHeap.size < minHeap.size) {
                maxHeap.offer(minHeap.poll())
            } else if (maxHeap.size - minHeap.size > 1) {
                minHeap.offer(maxHeap.poll())
            }

            if (maxHeap.size == minHeap.size) {
                val median = (maxHeap.peek() * 1.0 + minHeap.peek()) / 2.0
                ans[i] = decimalFormat.format(median).toDouble()
            } else {
                ans[i] = maxHeap.peek().toDouble()
            }

        }

        return ans
    }
}

fun main() {
    val test = RunningMedian()
    println(test.runningMedian(arrayOf(1000,
        94455,
        20555,
        20535,
        53125,
        73634,
        148,
        63772,
        17738,
        62995)))
}