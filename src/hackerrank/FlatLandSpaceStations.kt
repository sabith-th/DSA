package hackerrank

import java.util.Collections

class FlatLandSpaceStations {
    fun flatlandSpaceStations(n: Int, c: Array<Int>): Int {
        c.sort()

        fun firstGreaterEqual(target: Int): Int {
            val i = c.binarySearch(target)
            return if (i < 0) (-i-1) else i
        }

        var ans = Int.MIN_VALUE
        for (i in 0..n-1) {
            val firstIndexGE = firstGreaterEqual(i)
            var minDist = Int.MAX_VALUE
            if (firstIndexGE < c.size) {
                minDist = minOf(minDist, Math.abs(c[firstIndexGE] - i))
            }
            if (firstIndexGE > 0) {
                minDist = minOf(minDist, Math.abs(c[firstIndexGE-1] - i))
            }
            ans = maxOf(ans, minDist)
        }
        return ans
    }
}

fun main() {
    val test = FlatLandSpaceStations()
    println(test.flatlandSpaceStations(20, arrayOf(13, 1, 11, 10, 6)))
}