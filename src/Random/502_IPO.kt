package Random

import java.util.PriorityQueue
import kotlin.collections.indices
import kotlin.collections.sortWith

class IPO {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        val n = profits.size
        val pc = mutableListOf<Pair<Int, Int>>()
        for (i in profits.indices) {
            pc.add(Pair(capital[i], profits[i]))
        }
        pc.sortWith(compareBy { it.first })

        val pq = PriorityQueue<Int>(Comparator { a, b -> a - b })
        var totalProfit = w
        var j = 0
        for (i in 0..<k) {
            while (j < n && pc[j].first <= totalProfit) {
                pq.add(pc[j].second)
                j++
            }

            if (pq.isEmpty()) break
            totalProfit += pq.remove()

        }

        return totalProfit
    }
}

