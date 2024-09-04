package graphs

import java.util.LinkedList
import java.util.PriorityQueue

class FindItinerary {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val ans = LinkedList<String>()
        val graph = mutableMapOf<String, PriorityQueue<String>>()
        for (t in tickets) {
            val from = t[0]
            val to = t[1]
            graph.getOrPut(from) { PriorityQueue() }.offer(to)
        }

        fun dfs(u: String) {
            val arrivals = graph.getOrDefault(u, PriorityQueue())
            while (arrivals.isNotEmpty()) {
                dfs(arrivals.poll())
            }
            ans.addFirst(u)
        }

        dfs("JFK")

        return ans
    }
}

fun main() {
    val test = FindItinerary()
    println(test.findItinerary(listOf(listOf("MUC","LHR"),listOf("JFK","MUC"),listOf("SFO","SJC"),listOf("LHR","SFO"))))
}