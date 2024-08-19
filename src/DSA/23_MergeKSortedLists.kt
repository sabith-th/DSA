package DSA

import DSA.MergeKSortedLists.ListNode
import java.util.PriorityQueue

class MergeKSortedLists {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pq = PriorityQueue<ListNode>(compareBy { it.`val` })
        val dummy = ListNode(0)
        var curr = dummy

        for (node in lists) {
            if (node != null) {
                pq.add(node)
            }
        }

        while (pq.isNotEmpty()) {
            val next = pq.poll()
            curr.next = next
            if (next.next != null) {
                pq.offer(next.next)
            }
            curr = curr.next!!
        }

        return dummy.next
    }

    fun printNodes(head: ListNode?) {
        if (head != null) {
            print("${head.`val`} ")
            printNodes(head.next)
        }
    }
}

fun main() {
    val test = MergeKSortedLists()
    //[[1,4,5],[1,3,4],[2,6]]
    val l1 = ListNode(1)
    l1.next = ListNode(4)
    l1.next?.next = ListNode(5)
    val l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next?.next = ListNode(4)
    val l3 = ListNode(2)
    l3.next = ListNode(6)
    println("Nodes to merge")
    test.printNodes(l1)
    test.printNodes(l2)
    test.printNodes(l3)
    val merged = test.mergeKLists(arrayOf(l1, l2, l3))
    println("\nMerged")
    test.printNodes(merged)
}