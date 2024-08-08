package DSA

import java.util.PriorityQueue

class KthLargestElementInArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>()
        for (num in nums) {
            if (minHeap.size < k) {
                minHeap.offer(num)
            } else {
                minHeap.peek()?.let {
                    if (it <= num) {
                        minHeap.poll()
                        minHeap.offer(num)
                    }
                }
            }
        }
        return minHeap.peek()
    }
}

fun main() {
    val test = KthLargestElementInArray()
    println(test.findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6), 4))
}