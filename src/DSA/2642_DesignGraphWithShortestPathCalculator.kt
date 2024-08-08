package DSA

class Graph(n: Int, edges: Array<IntArray>) {

    val maxCost = 1000000000

    val adjMatrix = Array<IntArray>(n) { IntArray(n) { maxCost } }

    init {
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            val c = edge[2]
            adjMatrix[u][v] = c
        }

        for (u in 0..<n) {
            adjMatrix[u][u] = 0
        }

        for (k in 0..<n) {
            for (i in 0..<n) {
                for (j in 0..<n) {
                    adjMatrix[i][j] = minOf(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j])
                }
            }
        }
    }

    fun addEdge(edge: IntArray) {
        val u = edge[0]
        val v = edge[1]
        val c = edge[2]
        for (i in 0..<adjMatrix.size) {
            for (j in 0..<adjMatrix.size) {
                adjMatrix[i][j] = minOf(adjMatrix[i][j], adjMatrix[i][u] + c + adjMatrix[v][j])
            }
        }
    }

    fun shortestPath(node1: Int, node2: Int): Int {
        return if (adjMatrix[node1][node2] == maxCost) -1 else adjMatrix[node1][node2]
    }

}
