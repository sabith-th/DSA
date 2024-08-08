package Random

import kotlin.collections.indices
import kotlin.collections.isNotEmpty
import kotlin.ranges.downTo
import kotlin.to

class SumOfSubarrayMins {
    fun sumSubarrayMins(arr: IntArray): Int {
        var ans = 0
        val n = arr.size
        val leftMinCount = IntArray(n)
        val rightMinCount = IntArray(n)
        val lStack = ArrayDeque<Pair<Int, Int>>()
        for (i in arr.indices) {
            var count = 1
            while (lStack.isNotEmpty() && lStack.last().first > arr[i]) {
                count += lStack.removeLast().second
            }
            lStack.add(arr[i] to count)
            leftMinCount[i] = count
        }
        val rStack = ArrayDeque<Pair<Int, Int>>()
        for (i in arr.size-1 downTo 0) {
            var count = 1
            while (rStack.isNotEmpty() && rStack.last().first >= arr[i]) {
                count += rStack.removeLast().second
            }
            rStack.add(arr[i] to count)
            rightMinCount[i] = count
        }
        for (i in arr.indices) {
            ans += (arr[i] * leftMinCount[i] * rightMinCount[i]) % 1_000_000_007
        }
        return ans
    }
}

fun main() {
    val test = SumOfSubarrayMins()
    println(test.sumSubarrayMins(intArrayOf(11,81,94,43,3)))
}