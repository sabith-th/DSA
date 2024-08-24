package graphs

class PathSumIII {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        val sumCounter = mutableMapOf<Long, Int>().apply { put(0L, 1) }

        fun dfs(node: TreeNode?, currentSum: Long): Int {
            if (node == null) return 0

            val newSum = currentSum + node.`val`
            var counts = sumCounter.getOrDefault(newSum - targetSum, 0)
            sumCounter.merge(newSum, 1, Int::plus)
            counts += dfs(node.left, newSum)
            counts += dfs(node.right, newSum)
            sumCounter.merge(newSum, -1, Int::plus)
            return counts
        }

        return dfs(root, 0)
    }
}

fun main() {
    val test = PathSumIII()

}
