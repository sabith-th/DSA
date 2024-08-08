package days100placements100

class MinimumNumberOfTapsToWaterGarden {
    fun minTaps(n: Int, ranges: IntArray): Int {
        val maxReachable = IntArray(n+1)
        for (i in 0..<ranges.size) {
            if (ranges[i] == 0) continue
            val leftMax = maxOf(0, i - ranges[i])
            maxReachable[leftMax] = maxOf(maxReachable[leftMax], i + ranges[i])
        }

        var ans = 0
        var i = 0
        var end = 0
        var farCanReach = 0
        while (i < ranges.size && end < n) {
            ans++
            while (i < ranges.size && i <= end) {
                farCanReach = maxOf(maxReachable[i++], farCanReach)
            }
            if (end == farCanReach) return -1
            end = farCanReach
        }
        return ans
    }
}

fun main() {
    val test = MinimumNumberOfTapsToWaterGarden()
    println(test.minTaps(5, intArrayOf(3,4,1,1,0,0)))
}