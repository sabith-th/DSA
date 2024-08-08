package Random

import kotlin.collections.reduce

class SingleNumber {
    fun singleNumber(nums: IntArray): IntArray {
        val xor = nums.reduce { a, b -> a xor b }
        val lowbit = xor and -xor
        val ans = IntArray(2)
        for (num in nums) {
            if ((num and lowbit) > 0) {
                ans[0] = ans[0] xor num
            } else {
                ans[1] = ans[1] xor num
            }
        }
        return ans
    }
}