package twopointers

class MinAdjacentSwaps {
    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

    private fun nextPermutation(nums: IntArray) {
        var i = nums.size - 2
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) break
            i--
        }
        if (i < 0) {
            nums.reverse()
            return
        }
        var k = nums.size - 1
        while (k > i) {
            if (nums[k] > nums[i]) break
            k--
        }
        swap(nums, i, k)
        var l = i + 1
        var r = nums.size - 1
        while (l < r) {
            swap(nums, l++, r--)
        }
    }

    private fun countSteps(nums: IntArray, newNums: IntArray): Int {
        var i = 0
        var j = 0
        var count = 0
        while (i < newNums.size) {
            j = i
            while (nums[i] != newNums[j]) {
                j++
            }
            while (i < j) {
                swap(newNums, j, j-1)
                --j
                count++
            }
            i++
        }

        return count
    }

    fun getMinSwaps(num: String, k: Int): Int {
        var count = 0
        val nums = IntArray(num.length)
        val nextNum = IntArray(num.length)
        for (i in num.indices) {
            nextNum[i] = num[i] - '0'
            nums[i] = nextNum[i]
        }
        while (count < k) {
            nextPermutation(nextNum)
            count++
        }

        return countSteps(nums, nextNum)
    }
}

fun main() {
    val test = MinAdjacentSwaps()
    println("Computed: ${test.getMinSwaps(num = "5489355142", k = 4)} Expected: 2")
    println("Computed: ${test.getMinSwaps(num = "11112", k = 4)} Expected: 4")
    println("Computed: ${test.getMinSwaps(num = "00123", k = 1)} Expected: 1")
}