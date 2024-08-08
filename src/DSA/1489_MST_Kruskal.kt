package DSA

class MST_Kruskal {
    class DSU(val n: Int) {
        val parent = IntArray(n)
        val rank = IntArray(n)

        init {
            for (i in 0..<n) {
                parent[i] = i
            }
        }

        fun find(x: Int): Int {
            if (parent[x] == x) {
                return parent[x]
            } else {
                parent[x] = find(parent[x])
                return parent[x]
            }
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

    // Assumes edges are sorted in ascending order by weight. Edge = [u, v, w, original_index]
    fun MSTByKruskal(n: Int, edges: Array<IntArray>, include: Int = -1, exclude: Int = -1): Int {
        val dsu = DSU(n)
        var weight = 0

        if (include != -1) {
            weight += edges[include][2]
            dsu.union(edges[include][0], edges[include][1])
        }

        for (i in edges.indices) {
            if (i == exclude) continue
            val edge = edges[i]
            if (dsu.union(edge[0], edge[1])) {
                weight += edge[2]
            }
        }

        for (i in 0..<n) {
            if (dsu.find(0) != dsu.find(i)) return Int.MAX_VALUE
        }

        return weight
    }

    fun findCriticalAndPseudoCriticalEdges(n: Int, edges: Array<IntArray>): List<List<Int>> {
        val newEdges = Array<IntArray>(edges.size) { IntArray(4) }
        for (i in edges.indices) {
            newEdges[i] = intArrayOf(edges[i][0], edges[i][1], edges[i][2], i)
        }
        newEdges.sortBy { it[2] }

        val mstWeight = MSTByKruskal(n, newEdges)

        val criticalEdges = mutableListOf<Int>()
        val nonCriticalEdges = mutableListOf<Int>()

        for (i in newEdges.indices) {
            if (mstWeight < MSTByKruskal(n, newEdges, exclude = i)) {
                criticalEdges.add(newEdges[i][3])
            } else if (mstWeight == MSTByKruskal(n, newEdges, include = i)) {
                nonCriticalEdges.add(newEdges[i][3])
            }
        }
        return listOf(criticalEdges, nonCriticalEdges)
    }
}

fun main() {
    val test = MST_Kruskal()
//    println(test.findCriticalAndPseudoCriticalEdges(5, arrayOf(
//        intArrayOf(0,1,1),
//        intArrayOf(1,2,1),
//        intArrayOf(2,3,2),
//        intArrayOf(0,3,2),
//        intArrayOf(0,4,3),
//        intArrayOf(3,4,3),
//        intArrayOf(1,4,6))).toString())

    println(test.findCriticalAndPseudoCriticalEdges(6, arrayOf(
        intArrayOf(0,1,1),
        intArrayOf(1,2,1),
        intArrayOf(0,2,1),
        intArrayOf(2,3,4),
        intArrayOf(3,4,2),
        intArrayOf(3,5,2),
        intArrayOf(4,5,2))).toString())
}