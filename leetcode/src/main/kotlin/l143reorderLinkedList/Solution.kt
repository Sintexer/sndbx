package l143reorderLinkedList

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head == null || head.next == null) return
        // 1. find the middle or list without first node
        var slowPointer = head
        var fastPointer = slowPointer

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next!!.next
            slowPointer = slowPointer!!.next
        }

        // 2. reverse the second half
        var current = slowPointer!!.next
        var prev: ListNode? = null
        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }

        // 3. join two lists together
        slowPointer.next = null
        var first = head
        var second = prev

        while (second != null) {
            var next1 = first!!.next
            first.next = second
            var next2 = second!!.next
            second.next = next1
            first = next1
            second = next2
        }

    }
}
