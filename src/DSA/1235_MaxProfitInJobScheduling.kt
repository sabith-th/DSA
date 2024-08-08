package DSA

class MaxProfitInJobScheduling {
    private fun firstGreaterEqual(A: IntArray, startFrom: Int, target: Int): Int {
        var l = startFrom
        var r = A.size
        while (l < r) {
            val m = (l + r) / 2
            if (A[m] >= target)
                r = m
            else
                l = m + 1
        }
        return l
    }

    private fun schedule(jobs: Array<IntArray>, i: Int, dp: IntArray, startTime: IntArray): Int {
        if (i == jobs.size) {
            return 0
        }
        if (dp[i] != -1) return dp[i]
        val nextIndex = firstGreaterEqual(startTime, i+1, jobs[i][1])
        val maxProfit = maxOf(jobs[i][2] + schedule(jobs, nextIndex, dp, startTime), schedule(jobs, i+1, dp, startTime))
        dp[i] = maxProfit
        return maxProfit
    }

    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val jobs = Array<IntArray>(startTime.size) { IntArray(3) }
        for (i in startTime.indices) {
            jobs[i][0] = startTime[i]
            jobs[i][1] = endTime[i]
            jobs[i][2] = profit[i]
        }
        jobs.sortBy { it[0] }
        startTime.sort()
        val dp = IntArray(startTime.size + 1) { -1 }
        return dp[jobs.size-1]
    }
}