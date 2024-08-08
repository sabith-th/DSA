package dailyChallenges

class SortAnArray {
    fun sortArray(nums: IntArray): IntArray {
        mergeSort(nums, 0, nums.size-1)
        return nums
    }

    private fun mergeSort(nums: IntArray, l: Int, r: Int) {
        if (l >= r) return

        val m = (l + r) / 2
        mergeSort(nums, l, m)
        mergeSort(nums, m+1, r)
        merge(nums, l, m, r)
    }

    private fun merge(nums: IntArray, l: Int, m: Int, r: Int) {
        val sorted = IntArray(r - l + 1)
        var k = 0
        var i = l
        var j = m + 1

        while (i <= m && j <= r) {
            if (nums[i] < nums[j]) {
                sorted[k++] = nums[i++]
            } else {
                sorted[k++] = nums[j++]
            }
        }

        while (i <= m) {
            sorted[k++] = nums[i++]
        }

        while (j <= r) {
            sorted[k++] = nums[j++]
        }

        System.arraycopy(sorted, 0, nums, l, sorted.size)
    }
}