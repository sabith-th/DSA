package Random

import java.util.ArrayList
import kotlin.collections.indices
import kotlin.collections.plus
import kotlin.collections.toList

class Subsets {

    private fun helper(nums: List<Int>): MutableSet<List<Int>> {
        if (nums.isEmpty()) {
            return mutableSetOf()
        }

        val ans = mutableSetOf<List<Int>>()
        ans.add(nums)
        for (i in nums.indices) {
            ans.addAll(helper(nums.subList(0, i) + nums.subList(i + 1, nums.size)))
        }
        ans.add(intArrayOf().toList())
        return ans
    }

    private fun dfs(nums: IntArray, s: Int, path: MutableList<Int>, ans: MutableList<List<Int>>) {
        ans.add(ArrayList(path))

        for (i in s..<nums.size) {
            path.add(nums[i])
            dfs(nums, i + 1, path, ans)
            path.removeAt(path.size - 1)
        }
    }

    fun subsets(nums: IntArray): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        dfs(nums, 0, ArrayList(), ans)
        return ans
    }
}