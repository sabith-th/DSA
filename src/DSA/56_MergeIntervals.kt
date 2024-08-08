package DSA

class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
//        intervals.sortWith(compareBy ({ it[0] }, {it[1]}))
        intervals.sortBy { it[0] }
        val ans = mutableListOf<IntArray>()
        var currentInterval = intervals[0]
        for (i in 1..<intervals.size) {
            if (currentInterval[1] >= intervals[i][0]) {
                currentInterval[1] = maxOf(intervals[i][1], currentInterval[1])
            } else {
                ans.add(currentInterval)
                currentInterval = intervals[i]
            }
        }
        ans.add(currentInterval)
        return ans.toTypedArray()
    }
}