package Random

class HouseRobber {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        var prev2 = nums[0]
        if (n==1) return nums[0]
        var prev1 = maxOf(nums[1], nums[0])
        for (i in 2..<n) {
            val curr = maxOf(prev1, nums[i] + prev2)
            prev2 = prev1
            prev1 = curr
        }
        return prev1
    }
}