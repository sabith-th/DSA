package days100placements100

import java.util.Collections
import kotlin.math.abs

class PartitionArray {
    private fun firstGreaterEqual(A: List<Int>, target: Int): Int {
        val i = Collections.binarySearch<Int>(A, target)
        return if (i < 0) (-i-1) else i
    }

    fun minimumDifference(nums: IntArray): Int {
        val N = nums.size
        val n = N / 2
        val left = Array<MutableList<Int>>(n+1) { mutableListOf() }
        val right = Array<MutableList<Int>>(n+1) { mutableListOf() }
        val sum = nums.sum()
        var res = 0

        //Storing all possible sum in left and right
        var mask = 0
        while (mask < (1 shl n)) {
            var sz = 0
            var l = 0
            var r = 0
            for (i in 0..<n) {
                if ((mask and (1 shl i)) > 0) {
                    sz++
                    l += nums[i]
                    r += nums[i+n]
                }
            }
            left[sz].add(l)
            right[sz].add(r)
            mask++
        }

        for (sz in right.indices) {
            right[sz].sort()
        }

        for (sz in 1..<n) {
            for (a in left[sz]) {
                val b = (sum - 2 * a) / 2
                val rsz = n - sz
                val v = right[rsz]
                val ind = firstGreaterEqual(v, b)
                if (ind != v.size) {
                    res = minOf(res, abs(sum - 2 * (a + v[ind])))
                }
                if (ind != 0) {
                    res = minOf(res, abs(sum - 2 * (a + v[ind-1])))
                }
            }
        }
        return res
    }
}