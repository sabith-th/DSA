package Random

class MinimumIncrementToMakeUniqueArray {
    fun minIncrementForUnique(nums: IntArray): Int {
        var ans = 0
        var minAvailable = 0
        nums.sort()

        for (num in nums) {
            ans += maxOf(minAvailable - num, 0)
            minAvailable = maxOf(minAvailable, num) + 1
        }
        return ans
    }
}