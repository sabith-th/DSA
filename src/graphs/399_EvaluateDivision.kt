package graphs

class EvaluateDivision {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val adjList = mutableMapOf<String, MutableList<Pair<String, Double>>>()
        for (i in equations.indices) {
            val A = equations[i][0]
            val B = equations[i][1]
            val C = values[i]
            adjList.getOrPut(A) { mutableListOf() }.add(Pair(B, C))
            adjList.getOrPut(B) { mutableListOf() }.add(Pair(A, 1.0/C))
        }

        val ans = DoubleArray(queries.size) { -1.0 }

        fun dfs(a: String, b: String, visited: MutableSet<String>): Double {
            if (a == b) return 1.0
            visited.add(a)
            for ((c, value) in adjList.getOrDefault(a, emptyList())) {
                if (c in visited) continue
                val res = dfs(c, b, visited)
                if (res > 0) {
                    return res * value
                }
            }
            return -1.0
        }

        for (i in queries.indices) {
            val a = queries[i][0]
            val b = queries[i][1]
            if (a !in adjList || b !in adjList) {
                continue
            } else {
                val visited = mutableSetOf<String>()
                ans[i] = dfs(a, b, visited)
            }
        }

        return ans
    }
}

fun main() {
    val test = EvaluateDivision()
    var equations = listOf(listOf("a","b"),listOf("b","c"))
    var values = doubleArrayOf(2.0,3.0)
    var queries = listOf(listOf("a","c"),listOf("b","a"),listOf("a","e"),listOf("a","a"),listOf("x","x"))
    println("Computed: [${test.calcEquation(equations, values, queries).joinToString(", ")}] Expected: [6.00000,0.50000,-1.00000,1.00000,-1.00000]")
}