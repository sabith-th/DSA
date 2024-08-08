package Random

import kotlin.collections.indices
import kotlin.collections.sort
import kotlin.collections.sortWith

class MostProfitAssigningWork {
    fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        var ans = 0
        val jobs = mutableListOf<Pair<Int, Int>>()

        for (i in difficulty.indices) {
            jobs.add(Pair(difficulty[i], profit[i]))
        }

        jobs.sortWith(compareBy { it.first })

        worker.sort()

        var i = 0
        var maxProfit = 0

        for (w in worker) {
            while (i < jobs.size && w >= jobs[i].first) {
                maxProfit = maxOf(maxProfit, jobs[i].second)
            }
            ans += maxProfit
        }

        return ans
    }
}