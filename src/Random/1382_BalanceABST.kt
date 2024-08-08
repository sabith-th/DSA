package Random

class BalanceABinarySearchTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    val values = mutableListOf<Int>()

    private fun inorder(node: TreeNode?) {
        if (node == null) {
            return
        }
        inorder(node.left)
        values.add(node.`val`)
        inorder(node.right)
    }

    private fun buildBST(start: Int, end: Int): TreeNode? {
        if (start > end) {
            return null
        }
        val mid = (start + end) / 2
        val node = TreeNode(values[mid])
        node.left = buildBST(start, mid-1)
        node.right = buildBST(mid+1, end)
        return node
    }

    fun balanceBST(root: TreeNode?): TreeNode? {
        inorder(root)
        return buildBST(0, values.size-1)
    }
}

fun main() {

}