package Random

class MaxSumCircularSubarray {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        var prefixSum = 0
        var maxSoFar = Int.MIN_VALUE
        var totalSum = 0
        for (num in nums) {
            totalSum += num
            prefixSum += num
            maxSoFar = maxOf(maxSoFar, prefixSum)
            if (prefixSum < 0) {
                prefixSum = 0
            }
        }

        prefixSum = 0
        var minSoFar = Int.MAX_VALUE
        for (num in nums) {
            prefixSum += num
            minSoFar = minOf(minSoFar, prefixSum)
            if (prefixSum > 0) {
                prefixSum = 0
            }
        }

        return maxOf(maxSoFar, totalSum - minSoFar)
    }
}