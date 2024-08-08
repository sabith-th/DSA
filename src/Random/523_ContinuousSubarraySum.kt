package Random

import kotlin.collections.contains
import kotlin.collections.indices
import kotlin.collections.set

class ContinuousSubarraySum {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        var prefix = 0
        val sumMap = mutableMapOf<Int, Int>()
        sumMap[0] = -1
        for (i in nums.indices) {
            prefix += nums[i]
            if (k != 0) prefix %= k
            if (prefix in sumMap) {
                if ((i - sumMap[prefix]!!) > 1) return true
            } else {
                sumMap[prefix] = i
            }
        }
        return false
    }
}

fun main() {
    val test = ContinuousSubarraySum()
    println(test.checkSubarraySum(intArrayOf(23,2,4,6,7), 6))
    println(test.checkSubarraySum(intArrayOf(23,2,6,4,7), 13))
}