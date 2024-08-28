package dailyChallenges

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class StepByStepDirectionsFromBinaryTreeNodeAtoNodeB {
    private fun getPath(node: TreeNode?, target: Int, path: MutableList<Char>): Boolean {
        if (node == null) {
            return false
        } else if (node.`val` == target) {
            return true
        } else if (getPath(node.left, target, path)) {
            path.add('L')
            return true
        } else if (getPath(node.right, target, path)) {
            path.add('R')
            return true
        }
        return false
    }

    fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
        val pathToStart = mutableListOf<Char>()
        val pathToDest = mutableListOf<Char>()
        getPath(root, startValue, pathToStart)
        getPath(root, destValue, pathToDest)
        pathToStart.reverse()
        pathToDest.reverse()
        var i = 0
        var j = 0
        while (i < pathToStart.size && j < pathToDest.size) {
            if (pathToStart[i] != pathToDest[j]) {
                break
            }
            i++
            j++
        }
        var ans = ""
        var k = pathToStart.size - 1
        while (k >= i) {
            ans = "${ans}U"
            k--
        }
        while (j < pathToDest.size) {
            ans = "${ans}${pathToDest[j]}"
            j++
        }
        return ans
    }
}