package Random

class AllAncestorsOfANodeInADAG {
    private fun dfs(graph: Array<MutableList<Int>>, u: Int, ancestor: Int, seen: BooleanArray, ans: List<MutableList<Int>>) {
        seen[u] = true
        for (v in graph[u]) {
            if (seen[v])
                continue;
            ans[v].add(ancestor);
            dfs(graph, v, ancestor, seen, ans);
        }
    }

    fun getAncestors(n: Int, edges: Array<IntArray>): List<List<Int>> {
        val ans = mutableListOf<MutableList<Int>>()
        val graph = Array<MutableList<Int>>(n) {mutableListOf<Int>()}

        for ( i in 0..<n) {
            ans.add(mutableListOf())
            graph[i] = mutableListOf<Int>()
        }

        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            graph[u].add(v)
        }

        for (i in 0..<n)
            dfs(graph, i, i, BooleanArray(n), ans)

        return ans
    }

}