package days100placements100

class NextGreaterElementIII {
    fun nextGreaterElement(n: Int): Int {
        val nums = n.toString().toCharArray()
        val n = nums.size - 1
        var k = n - 1
        while (k >= 0) {
            if (nums[k] < nums[k+1]) break
            k--
        }
        if (k < 0) return -1
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

        val next = nums.joinToString("").toLong()
        if (next > Int.MAX_VALUE) return -1
        return next.toInt()
    }
}

fun main() {
    val test = NextGreaterElementIII()
    println(test.nextGreaterElement(21))
}