package graphs

class DeleteNodeInABST {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null
        if (key < root.`val`) {
            root.left = deleteNode(root.left, key)
            return root
        }
        if (key > root.`val`) {
            root.right = deleteNode(root.right, key)
            return root
        }
        if (root.left == null) return root.right
        if (root.right == null) return root.left
        var successor = root.right
        while (successor?.left != null) {
            successor = successor.left
        }
        successor?.left = root.left
        val newRoot = root.right
        return newRoot
    }
}