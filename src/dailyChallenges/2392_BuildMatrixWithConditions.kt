package dailyChallenges

class BuildMatrixWithConditions {
    private fun buildGraph(conditions: Array<IntArray>, k: Int): Array<MutableList<Int>> {
        val graph = Array<MutableList<Int>>(k+1) { mutableListOf() }
        for (cond in conditions) {
            graph[cond[0]].add(cond[1])
        }
        return graph
    }

    private fun topologicalSort(graph: Array<MutableList<Int>>, k: Int): MutableList<Int> {
        val inDegree = IntArray(k+1)
        val topologicallySortedNodes = mutableListOf<Int>()
        for (u in graph.indices) {
            for (v in graph[u]) {
                inDegree[v]++
            }
        }
        val q = ArrayDeque<Int>()
        for (i in 1..k) {
            if (inDegree[i] == 0) {
                q.add(i)
            }
        }

        while (q.isNotEmpty()) {
            val node = q.removeFirst()
            topologicallySortedNodes.add(node)
            for (v in graph[node]) {
                inDegree[v]--
                if (inDegree[v] == 0) {
                    q.add(v)
                }
            }
        }
        if (topologicallySortedNodes.size < k) return mutableListOf()
        return topologicallySortedNodes
    }

    private fun fillTopologicallySortedNodesList(nodes: MutableList<Int>, k: Int) {
        val seen = mutableSetOf<Int>()
        for (node in nodes) seen.add(node)
        for (i in 1..k) {
            if (i !in seen) {
                nodes.add(i)
            }
        }
    }


    fun buildMatrix(k: Int, rowConditions: Array<IntArray>, colConditions: Array<IntArray>): Array<IntArray> {
        val rowDependencyGraph = buildGraph(rowConditions, k)
        val colDependencyGraph = buildGraph(colConditions, k)

        val topoSortedRows = topologicalSort(rowDependencyGraph, k)
        val topoSortedCols = topologicalSort(colDependencyGraph, k)

        if (topoSortedRows.isEmpty() || topoSortedCols.isEmpty()) return emptyArray()

        fillTopologicallySortedNodesList(topoSortedRows, k)
        fillTopologicallySortedNodesList(topoSortedCols, k)

        val ans = Array<IntArray>(k) { IntArray(k) }

        val colIndex = mutableMapOf<Int, Int>()
        for (j in 0..<k) {
            colIndex[topoSortedCols[j]] = j
        }

        for (i in 0..<k) {
            ans[i][colIndex[topoSortedRows[i]]!!] = topoSortedRows[i]
        }

        return ans
    }
}