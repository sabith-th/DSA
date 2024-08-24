package graphs

class LongestZigZagPathInBinaryTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun longestZigZag(root: TreeNode?): Int {
        var ans = 0

        fun dfs(node: TreeNode?, leftLength: Int, rightLength: Int) {
            if (node == null) return
            ans = maxOf(ans, leftLength, rightLength)
            dfs(node.left, 1 + rightLength, 0)
            dfs(node.right, 0, 1 + leftLength)
        }


        dfs(root, 0, 0)
        return ans
    }
}