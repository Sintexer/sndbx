package l19removeNthNodeFromEndOfList

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    @Deprecated("wrong solution - redundant reverse")
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        head ?: return null

        fun reverseList(headNode: ListNode?): ListNode? {
            headNode ?: return null
            var current = headNode
            var prev: ListNode? = null
            while (current != null) {
                val next = current.next
                current.next = prev
                prev = current
                current = next
            }
            return prev
        }
        val reverseHead = reverseList(head)

        var current = reverseHead
        var prev: ListNode? = null
        for (i in 1 until n) {
            val next = current!!.next
            prev = current
            current = next
        }
        val next = current?.next
        prev?.next = current?.next
        current?.next = null

        return reverseList(if (prev != null) reverseHead else next)
    }
}

class SimplerSolution {
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
