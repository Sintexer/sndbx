package l141linkedListCycle

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var fastPointer = head
        var slowPointer = head

        while (fastPointer != null && fastPointer.next != null && slowPointer != null ) {
            fastPointer = fastPointer.next!!.next
            slowPointer = slowPointer.next
            if (slowPointer == fastPointer) return true
        }
        return false
    }
}
