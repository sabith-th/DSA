package days100placements100

class NextPermutation {
    fun nextPermutation(nums: IntArray): Unit {
        val n = nums.size - 1
        var k = n - 1
        while (k >= 0) {
            if (nums[k] < nums[k+1]) break
            k--
        }
        if (k < 0) {
            nums.reverse()
            return
        }
        var l = n
        while (l > k) {
            if (nums[k] < nums[l]) break
            l--
        }

        fun swap(i: Int, j: Int) {
            val temp = nums[j]
            nums[j] = nums[i]
            nums[i] = temp
        }

        swap(k, l)

        var i = k + 1
        var j = n
        while (i < j) {
            swap(i++, j--)
        }
    }
}

fun main() {
    val test = NextPermutation()
    val test1 = intArrayOf(1, 2, 3)
    test.nextPermutation(test1)
    println(test1.contentToString())
    val test2 = intArrayOf(1, 3, 2)
    test.nextPermutation(test2)
    println(test2.contentToString())
}