package Random

class PatchingArray {
    fun minPatches(nums: IntArray, n: Int): Int {
        var minNumberOfPatches = 0
        var maxNumber: Long = 0
        var i = 0
        val sz = nums.size
        while (maxNumber < n) {
            if (i < sz && maxNumber + 1 >= nums[i]) {
                maxNumber += nums[i]
                i++
            } else {
                minNumberOfPatches++
                maxNumber += (maxNumber + 1)
            }
        }
        return minNumberOfPatches
    }
}