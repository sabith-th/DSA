package Random

/**
 * Example:
 * var li = Random.ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class Random.ListNode(var `val`: Int) {
 *     var next: Random.ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    private fun helper(node: ListNode?): Pair<ListNode?, Int> {
        if (node == null) return Pair(null, 0)

        val nextPair = helper(node.next)
        val doub = node.`val` * 2
        val newNode = ListNode(doub % 10 + nextPair.second)
        newNode.next = nextPair.first
        return Pair(newNode, doub / 10)
    }

    fun doubleIt(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        val resPair = helper(head)
        if (resPair.second == 1) {
            val newHead = ListNode(1)
            newHead.next = resPair.first
            return newHead
        } else {
            return resPair.first
        }
    }
}