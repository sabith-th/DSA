package Random

class CountNumberOfNiceSubArrays {
    private fun numberOfSubarraysAtmostK(nums: IntArray, k: Int): Int {
        var ans = 0
        var l = 0
        var r = 0
        var k_ = k
        while (r <= nums.size) {
            if (k_ >= 0) {
                ans += r - l
                if (r == nums.size)
                    break
                if (nums[r] % 2 == 1)
                    k_--
                r++
            } else {
                if (nums[l] % 2 == 1)
                    k_++
                l++
            }
        }
        return ans
    }

    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        return numberOfSubarraysAtmostK(nums, k) - numberOfSubarraysAtmostK(nums, k-1)
    }
}