package Random

class MinimumNumberOfKConsecutiveBitFlips {
    fun minKBitFlips(nums: IntArray, k: Int): Int {
        val n = nums.size
        var ans = 0
        var times  = 0
        for (i in nums.indices) {
            if (i >= k) {
                if (nums[i-k] > 1) {
                    nums[i-k] -= 2
                    times--
                }
            }
            if ((nums[i] == 0 && times % 2 == 0) || (nums[i] == 1 && times % 2 == 1)) {
                if (i + k > n) {
                    return -1
                }
                ans++
                times++
                nums[i] += 2
            }
        }
        if (nums[n-k] > 1) {
            nums[n-k] -= 2
        }
        return ans
    }
}