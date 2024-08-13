package DSA

class PartitionToKEqualSubsets {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        val total = nums.sum()
        if (total % k != 0) return false
        val target = total / k
        nums.sortDescending()
        val subsetSums = IntArray(k)

        fun dfs(i: Int): Boolean {
            if (i < 0) {
                for (sum in subsetSums) {
                    if (sum != target) return false
                }
                return true
            }
            for (j in subsetSums.indices) {
                if (j > 0 && subsetSums[j] == subsetSums[j - 1]) {
                    continue
                }

                subsetSums[j] += nums[i]

                if (subsetSums[j] <= target && dfs(i-1)) {
                    return true
                }

                subsetSums[j] -= nums[i]

                if (subsetSums[j] == 0) break
            }

            return false
        }

        return dfs(nums.lastIndex)
    }
}

fun main() {
    val test = PartitionToKEqualSubsets()
    println(test.canPartitionKSubsets(intArrayOf(4,3,2,3,5,2,1), k = 4))
    println(test.canPartitionKSubsets(intArrayOf(1,2,3,4), k = 3))
}