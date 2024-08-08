package Random

import kotlin.collections.indices

class SortColors {
    fun sortColors(nums: IntArray): Unit {
        var zero = -1
        var one = -1
        var two = -1
        for (num in nums) {
            if (num == 0) {
                nums[++two] = 2
                nums[++one] = 1
                nums[++zero] = 0
            } else if (num == 1) {
                nums[++two] = 2
                nums[++one] = 1
            } else {
                nums[++two] = 2
            }
        }
    }

    fun sortColors2(nums: IntArray): Unit {
        for (i in nums.indices) {
            for (j in nums.indices) {
                if (nums[i] > nums[j]) {
                    val temp = nums[j]
                    nums[j] = nums[i]
                    nums[i] = temp
                }
            }
        }
    }
}