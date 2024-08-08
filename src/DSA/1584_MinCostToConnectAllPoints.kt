package DSA

import kotlin.math.abs

class MinCostToConnectAllPoints {
    class DSU(val n: Int) {
        val parent = IntArray(n)
        val rank = IntArray(n)

        init {
            for (i in 0..<n) {
                parent[i] = i
            }
        }

        fun find(x: Int): Int {
            if (parent[x] == x) return parent[x]
            parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(x: Int, y: Int): Boolean {
            val xRoot = find(x)
            val yRoot = find(y)
            if (xRoot != yRoot) {
                if (rank[xRoot] < rank[yRoot]) parent[xRoot] = yRoot else parent[yRoot] = xRoot
                rank[xRoot] += if (rank[xRoot] == rank[yRoot]) 1 else 0
                return true
            }
            return false
        }
    }

    fun mstKruskal(n: Int, edges: List<IntArray>): Int {
        val dsu = DSU(n)
        var weight = 0
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            val w = edge[2]
            if (dsu.union(u, v)) {
                weight += w
            }
        }

        return weight
    }
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val edges = mutableListOf<IntArray>()
        for (i in 0..<points.size - 1) {
            for (j in i+1..<points.size) {
                val distance = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1])
                edges.add(intArrayOf(i, j, distance))
            }
        }
        edges.sortBy { it[2] }
        return mstKruskal(points.size, edges)
    }
}