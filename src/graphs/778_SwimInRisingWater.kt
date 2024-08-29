package graphs

import java.util.PriorityQueue

class SwimInRisingWater {
    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size
        val pq = PriorityQueue<List<Int>>(compareBy { it[0] })
        val seen = Array<BooleanArray>(n) { BooleanArray(n) }
        seen[0][0] = true
        var ans = grid[0][0]
        val dirs = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
        pq.offer(listOf(grid[0][0], 0, 0))
        while (pq.isNotEmpty()) {
            val top = pq.poll()
            val h = top[0]
            val u = top[1]
            val v = top[2]
            ans = maxOf(ans, h)
            if (u == n-1 && v == n-1) break
            for ((dX, dY) in dirs) {
                val x = u + dX
                val y = v + dY
                if (x < 0 || x >= n || y < 0 || y >= n) continue
                if (seen[x][y]) continue
                pq.offer(listOf(grid[x][y], x, y))
                seen[x][y] = true
            }

        }
        return ans
    }
}