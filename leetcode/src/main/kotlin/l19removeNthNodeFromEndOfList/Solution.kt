package l19removeNthNodeFromEndOfList

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        head ?: return null

        val anchor = ListNode(0)
        anchor.next = head
        var offset = head
        for (i in 0 until n) {
            offset = offset!!.next
        }
        var prev: ListNode? = anchor
        while (offset != null) {
            offset = offset.next
            prev = prev!!.next
        }

        prev!!.next = prev.next?.next

        return anchor.next
    }
}
