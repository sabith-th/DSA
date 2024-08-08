package Random

class BeautifulSubsets {

    private fun dfs(i: Int, nums: IntArray, k: Int, totalBeautifulSubsets: Int, count: IntArray): Int {
        if (i >= nums.size) {
            return totalBeautifulSubsets + 1
        }

        var temp = dfs(i+1, nums, k, totalBeautifulSubsets, count)

        val isBeautifulWithNext = nums[i] + k >= count.size || count[nums[i] + k] == 0
        val isBeautifulWithPrevious = nums[i] - k < 0 || count[nums[i] - k] == 0

        if (isBeautifulWithPrevious && isBeautifulWithNext) {
            count[nums[i]]++
            temp += dfs(i + 1, nums, k, totalBeautifulSubsets, count)
            count[nums[i]]--
        }
        return temp
    }

    fun beautifulSubsets(nums: IntArray, k: Int): Int {
        val count = IntArray(1010)
        return dfs(0, nums, k, 0, count) - 1
    }
}