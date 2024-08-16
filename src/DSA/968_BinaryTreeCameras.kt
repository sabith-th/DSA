package DSA

class BinaryTreeCameras {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    // 0 := all the nodes below the root are covered except the root
    // 1 := all the nodes below and including the root are covered with no camera
    // 2 := all nodes below and including the root are covered with a camera
    private fun dfs(root: TreeNode?): IntArray {
        if (root == null)
            return  intArrayOf(0, 0, 1000)

        val l = dfs(root.left)
        val r = dfs(root.right)

        val s0 = l[1] + r[1]
        val s1 = minOf(l[2] + minOf(r[1], r[2]),  r[2] + minOf(l[1], l[2]))
        val s2 = minOf(l[0], minOf(l[1], l[2])) + minOf(r[0], minOf(r[1], r[2])) + 1

        return intArrayOf(s0, s1, s2)
    }

    fun minCameraCover(root: TreeNode?): Int {
        val ans = dfs(root)
        return minOf(ans[1], ans[2])
    }


}