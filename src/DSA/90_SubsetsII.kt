package DSA

class SubsetsII {
    private fun backTrack(nums: IntArray, start: Int, path: MutableList<Int>, ans: MutableList<MutableList<Int>>) {
        ans.add(ArrayList(path))
        for (i in start..<nums.size){
            if (i > start && nums[i] == nums[i-1]) continue
            path.add(nums[i])
            backTrack(nums, i+1, path, ans)
            path.removeLast()
        }
    }

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val ans = mutableListOf<MutableList<Int>>()
        val path = mutableListOf<Int>()
        nums.sort()
        backTrack(nums, 0, path, ans)
        return ans
    }
}

fun main() {
    val test = SubsetsII()
    println(test.subsetsWithDup(intArrayOf(1, 2, 2, 2, 3)))
}