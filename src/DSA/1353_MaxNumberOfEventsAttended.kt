package DSA

import java.util.PriorityQueue

class MaxNumberOfEventsThatCanBeAttended {
    fun maxEvents(events: Array<IntArray>): Int {
        events.sortBy { it[0] }
        val pq = PriorityQueue<Int>()
        var attended = 0
        var d = 1
        var i = 0
        while(pq.isNotEmpty() || i < events.size) {
            if (pq.isEmpty()) {
                d = events[i][0]
            }
            while (i < events.size && events[i][0] == d) {
                pq.add(events[i++][1])
            }
            pq.poll()
            d++
            attended++
            while (pq.isNotEmpty() && pq.peek() < d) {
                pq.poll()
            }
        }
        return attended
    }
}