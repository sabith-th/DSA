package graphs

class ReorderRoutesToMakePathsLeadToZero {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val adjList = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        for (conn in connections) {
            val a = conn[0]
            val b = conn[1]
            adjList.getOrPut(a) { mutableListOf() }.add(b to 1)
            adjList.getOrPut(b) { mutableListOf() }.add(a to -1)
        }
        val visited = BooleanArray(n)
        var ans = 0

        fun dfs(a: Int) {
            if (visited[a]) return
            visited[a] = true
            for ((b, w) in adjList.getOrDefault(a, emptyList())) {
                if (!visited[b]) {
                    if (w > 0) ans++
                    dfs(b)
                }
            }
        }

        dfs(0)
        return ans
    }
}

fun main() {
    val test = ReorderRoutesToMakePathsLeadToZero()
    println("Computed: ${test.minReorder(n = 6, connections = arrayOf(intArrayOf(0,1),intArrayOf(1,3),intArrayOf(2,3),intArrayOf(4,0),intArrayOf(4,5)))} Expected: 3")
    println("Computed: ${test.minReorder(n = 5, connections = arrayOf(intArrayOf(0,1),intArrayOf(1,2),intArrayOf(3,2),intArrayOf(3,4)))} Expected: 2")
    println("Computed: ${test.minReorder(n = 3, connections = arrayOf(intArrayOf(1,0),intArrayOf(2,0)))} Expected: 0")
}