package DSA

import DSA.ReverseNodesInKGroups.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class ReverseNodesInKGroups {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    private fun reverse(start: ListNode, end: ListNode): Pair<ListNode, ListNode> {
        var endNext = end.next
        var dummy = ListNode(-1)
        dummy.next = start
        var prev = dummy
        var curr: ListNode? = start
        while (curr != endNext) {
            var temp = curr?.next
            curr?.next = prev
            prev = curr!!
            curr = temp
        }
        start.next = endNext
        return end to start
    }

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val dummy = ListNode(-1)
        dummy.next = head
        var prevTail = dummy
        var curr = head
        while (curr != null) {
            var count = 1
            val start = curr
            while (curr != null && count < k) {
                curr = curr.next
                count++
            }
            if (curr == null) break
            val end = curr
            val (newStart, newEnd) = reverse(start, end)
            prevTail.next = newStart
            prevTail = newEnd
            curr = newEnd.next
        }

        return dummy.next
    }

    fun printNodes(node: ListNode?) {
        if (node != null) {
            print("${node.`val`} ")
            printNodes(node.next)
        }
    }
}

fun main() {
    val test = ReverseNodesInKGroups()
    //Input: head = [1,2,3,4,5], k = 2
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)
    test.printNodes(head)
    println("\nAfter reverse in group 2")
    val reversed = test.reverseKGroup(head, 2)
    test.printNodes(reversed)

}