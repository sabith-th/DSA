package DSA

class SubArraysWithKDifferentIntegers {
    private fun withAtmostK(nums: IntArray, k:Int): Int {
        var ans = 0
        val freq = mutableMapOf<Int, Int>()
        var l = 0
        var r = 0
        var count = k
        while (r < nums.size) {
            freq.merge(nums[r], 1, Integer::sum)
            if (freq[nums[r]]!! == 1) count--
            while (count == -1) {
                freq.merge(nums[l], -1, Integer::sum)
                if (freq[nums[l++]]!! == 0) count++
            }
            ans += r - l + 1
            r++
        }
        return ans
    }

    fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
        return withAtmostK(nums, k) - withAtmostK(nums, k-1)
    }
}

fun main() {
    val test = SubArraysWithKDifferentIntegers()
//    println(test.subarraysWithKDistinct(intArrayOf(1,2,1,2,3), 2))
//    println(test.subarraysWithKDistinct(intArrayOf(1,2,1,3,4), 3))
    println(test.subarraysWithKDistinct(intArrayOf(1, 2), 1))
}