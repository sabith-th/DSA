package DSA

class FourSum {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val n = nums.size
        if (n < 4) return emptyList()
        nums.sort()
        val ans = mutableListOf<List<Int>>()
        for (i in 0..n-4) {
            if (i > 0 && nums[i] == nums[i - 1]) continue
            for (j in i+1..n-3) {
                if (j > i+ 1 && nums[j] == nums[j-1]) continue
                val sum1: Long = nums[i] + nums[j] + 0L
                val targetSum = target - sum1
                var l = j + 1
                var r = n - 1
                while (l < r) {
                    val currSum = nums[l] + nums[r] + 0L
                    if (currSum == targetSum) {
                        ans += listOf(nums[i], nums[j], nums[l], nums[r])
                        l++
                        r--
                        while (l < r && nums[l] == nums[l - 1]) l++
                        while (l < r && nums[r] == nums[r + 1]) r--
                    } else if (currSum < targetSum) {
                        l++
                    } else {
                        r--
                    }
                }
            }
        }
        return ans
    }
}

fun main() {
    val test = FourSum()
    println(test.fourSum(nums = intArrayOf(1,0,-1,0,-2,2), target = 0))
    println(test.fourSum(nums = intArrayOf(2,2,2,2,2), target = 8))
}