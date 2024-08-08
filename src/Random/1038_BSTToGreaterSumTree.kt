package Random

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinarySearchTreeToGreaterSumTree {
    private fun toGst(root: TreeNode?, sum: Int): Int {
        if (root == null) {
            return sum
        } else if (root.left == null && root.right == null) {
            root.`val` = root.`val` + sum
            return root.`val`
        }
        val rightSum = toGst(root.right, sum)
        root.`val` += rightSum
        return toGst(root.left, root.`val`)
    }

    fun bstToGst(root: TreeNode?): TreeNode? {
        toGst(root, 0)
        return root
    }
}