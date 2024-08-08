package Random
class SortList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }


    private fun middleNode(head: ListNode): ListNode? {
        var slow: ListNode? = head
        var fast: ListNode? = head.next
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        val mid = slow?.next
        slow?.next = null
        return mid
    }

    private fun merge(l1: ListNode?, l2: ListNode?): ListNode? {
        var dummyHead = ListNode(-1)
        var current: ListNode? = dummyHead
        var l = l1
        var r = l2
        while (l != null && r != null) {
            if (l.`val` <= r.`val`) {
                current?.next = l
                l = l.next
            } else {
                current?.next = r
                r = r.next
            }
            current = current?.next
        }
        current?.next = if (l != null) l else r

        return dummyHead.next
    }

    fun sortList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }
        val mid = middleNode(head)
        var left = sortList(head)
        var right = sortList(mid)
        return merge(left, right)
    }
}