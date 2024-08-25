package dailyChallenges

import dailyChallenges.BinaryTreePostorderTraversal.TreeNode
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class BinaryTreePostorderTraversal {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val stack = ArrayDeque<TreeNode>()
        stack.add(root)
        val ans = mutableListOf<Int>()
        while (stack.isNotEmpty()) {
            val top = stack.removeLast()
            ans.add(top.`val`)
            top.left?.let { stack.add(it) }
            top.right?.let { stack.add(it) }
        }
        ans.reverse()
        return ans
    }

    fun postorderTraversal2(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()

        fun dfs(node: TreeNode?) {
            if (node == null) return
            dfs(node.left)
            dfs(node.right)
            ans.add(node.`val`)
        }

        dfs(root)
        return ans
    }
}

fun main() {
    val test = BinaryTreePostorderTraversal()
    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right?.left = TreeNode(3)
    println(test.postorderTraversal(root))
    println(test.postorderTraversal2(root))
}