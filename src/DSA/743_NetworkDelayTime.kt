package DSA

import java.util.PriorityQueue

class NetworkDelayTime {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        // Node1 -> Pair of (Node2, Weight)
        val adjacencyList = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        for (i in 1..n) {
            adjacencyList[i] = mutableListOf<Pair<Int, Int>>()
        }
        for (time in times) {
            adjacencyList[time[0]]!!.add(Pair(time[1], time[2]))
        }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }).apply { add(k to 0) }
        val distance = mutableMapOf<Int, Int>()
        for (i in 1..n) {
            distance[i] = 1000
        }
        distance[k] = 0
        val visited = mutableSetOf<Int>()
        while (pq.isNotEmpty()) {
            val (node, currDelay) = pq.poll()
            if (node in visited) {
                continue
            }
            adjacencyList[node]?.forEach { (neighbor, delay) ->
                val totalDelay = currDelay + delay
                if (totalDelay < distance.getValue(neighbor)) {
                    distance[neighbor] = totalDelay
                    pq.add(neighbor to totalDelay)
                }
            }
            visited.add(node)
        }
        var minDelay = 0
        for (k in distance.keys) {
            if (distance.getValue(k) == 1000) {
                return -1
            }
            minDelay = maxOf(minDelay, distance.getValue(k))
        }
        return minDelay
    }
}