package dailyChallenges

class Node(var node: TreeNode, var parent: Int)

class DeleteNodesAndReturnForest {
    private fun buildTreeMap(root: TreeNode?, map: MutableMap<Int, Node>, parent: Int) {
        if (root == null) {
            return
        }
        map[root.`val`] = Node(root, parent)
        buildTreeMap(root.left, map, root.`val`)
        buildTreeMap(root.right, map, root.`val`)
    }

    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
        if (root == null || to_delete.isEmpty()) {
            return listOf(root)
        }
        val treeMap = mutableMapOf<Int, Node>()
        buildTreeMap(root, treeMap, 0)
        val ans = mutableListOf<TreeNode?>()
        for (i in to_delete.indices) {
            val node = treeMap[to_delete[i]]!!
            if (node.parent != 0) {
                val parent = treeMap[node.parent]!!.node
                if (parent.left == node.node) {
                    parent.left = null
                } else if (parent.right == node.node) {
                    parent.right = null
                }
            }
            node.node.left?.let {
                treeMap[it.`val`]!!.parent = 0
            }
            node.node.right?.let {
                treeMap[it.`val`]!!.parent = 0
            }
            node.node.left = null
            node.node.right = null

            treeMap.remove(to_delete[i])
        }
        for (key in treeMap.keys) {
            if (treeMap[key]!!.parent == 0) {
                ans.add(treeMap[key]?.node)
            }
        }
        return ans
    }
}