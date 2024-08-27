package dailyChallenges

import java.util.PriorityQueue

class PathWithMaxProbability {
    fun maxProbability(n: Int, edges: Array<IntArray>, successProb: DoubleArray, startNode: Int, endNode: Int): Double {
        val adjList = mutableMapOf<Int, MutableList<Pair<Int, Double>>>()
        for (i in edges.indices) {
            val a = edges[i][0]
            val b = edges[i][1]
            val w = successProb[i]
            adjList.getOrPut(a) { mutableListOf() }.add(b to w)
            adjList.getOrPut(b) { mutableListOf() }.add(a to w)
        }
        val visited = BooleanArray(n)
        val pq = PriorityQueue<Pair<Int, Double>>(compareByDescending { it.second })
        pq.offer(startNode to 1.0)
        while (pq.isNotEmpty()) {
            val (a, probA) = pq.poll()
            if (a == endNode) return probA
            if (visited[a]) continue
            visited[a] = true
            for ((b, probB) in adjList.getOrDefault(a, emptyList())) {
                if (visited[b]) continue
                pq.offer(b to probA * probB)
            }
        }
        return 0.0
    }
}

fun main() {
    val test = PathWithMaxProbability()
    println("""
        Computed: ${test.maxProbability(3, arrayOf(intArrayOf(0,1),intArrayOf(1,2),intArrayOf(0,2)), doubleArrayOf(0.5,0.5,0.2), 0, 2)}
        Expected: 0.25
    """.trimIndent())
    println("""
        Computed: ${test.maxProbability(3, arrayOf(intArrayOf(0,1),intArrayOf(1,2),intArrayOf(0,2)), doubleArrayOf(0.5,0.5,0.3), 0, 2)}
        Expected: 0.3
    """.trimIndent())
}