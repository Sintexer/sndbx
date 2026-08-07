package l21mergeTwoSortedLinkedLists

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null && list2 == null) return null
        val dummy = ListNode(0)
        var answer: ListNode = dummy
        var first = list1
        var second = list2
        while (first != null && second != null) {
            if (first.`val` < second.`val`) {
                answer.next = first
                answer = first
                first = first.next
            } else {
                answer.next = second
                answer = second
                second = second.next
            }
        }
        if (first != null) {
            answer.next = first
        } else {
            answer.next = second
        }

        answer = dummy.next!!
        dummy.next = null
        return answer
    }
}
