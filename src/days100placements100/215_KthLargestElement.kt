package days100placements100

import kotlin.random.Random

class KthLargestElementInArray {

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

    private fun quickSelect(nums: IntArray, l: Int, r: Int, k: Int): Int {
//        val randIndex = Random.nextInt(r-l+1) + l
//        swap(nums, randIndex, r)

        var nextSwapped = l
        for (i in l..<r) {
            if (nums[i] >= nums[r]) {
                swap(nums, i, nextSwapped++)
            }
        }
        swap(nums, nextSwapped, r)

        val count = nextSwapped - l + 1
        if (count == k) {
            return nums[nextSwapped]
        }
        if (count > k) {
            return quickSelect(nums, l, nextSwapped - 1, k - count)
        }
        return quickSelect(nums, nextSwapped + 1, r, k - count)
    }

    fun findKthLargest(nums: IntArray, k: Int): Int {
        return quickSelect(nums, 0, nums.size-1, k)
    }
}