package Random

class Solution1863 {
    fun subsetXORSum(nums: IntArray): Int {
        return dfs(nums, 0, 0)
    }

    private fun dfs(nums: IntArray, i: Int, xors: Int): Int {
        if (i == nums.size) {
            return xors
        }

        val x = dfs(nums,i+1, xors)
        val y = dfs(nums,i + 1, nums[i] xor xors)
        return x + y
    }
}