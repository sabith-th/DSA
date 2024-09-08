package dailyChallenges

class SplitLinkedListInParts {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        var count = 0
        var curr = head
        while (curr != null) {
            count++
            curr = curr.next
        }
        val ans = Array<ListNode?>(k) { null }
        val partCount = count / k
        var rem = count % k
        curr = head
        for (i in 0..<k) {
            ans[i] = curr
            val size = partCount + (if (rem > 0) 1 else 0)
            var j = 1
            while (curr != null && j < size) {
                curr = curr.next
                j++
            }
            var temp = curr?.next
            curr?.next = null
            curr = temp
            rem--
        }
        return ans
    }
}

