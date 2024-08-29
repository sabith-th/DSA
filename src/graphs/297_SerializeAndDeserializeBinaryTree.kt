package graphs

class TreeNode(var `val`: Int) {
     var left: TreeNode? = null
     var right: TreeNode? = null
 }

class Codec() {
    companion object {
        const val SEPARATOR = ","
        const val NULL = "#"
    }

    private fun serializePreOrder(node: TreeNode?, sb: StringBuilder) {
        if (node == null) {
            sb.append(NULL).append(SEPARATOR)
            return
        }
        sb.append(node.`val`).append(SEPARATOR)
        serializePreOrder(node.left, sb)
        serializePreOrder(node.right, sb)
    }

    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if (root == null) return ""
        val sb = StringBuilder()
        serializePreOrder(root, sb)
        return sb.toString()
    }

    private fun deserializePreOrder(nodes: MutableList<String>): TreeNode? {
        val value = nodes.removeFirst()
        if (value == NULL) return null
        val node = TreeNode(value.toInt())
        node.left = deserializePreOrder(nodes)
        node.right = deserializePreOrder(nodes)
        return node
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null
        val nodes = data.split(SEPARATOR).toMutableList()
        return deserializePreOrder(nodes)
    }
}

fun main() {
    val codec = Codec()
    val btString = "1,2,#,#,3,#,#,"
    println("Binary Tree String: $btString")
    val bTree = codec.deserialize(btString)
    println(codec.serialize(bTree))
}