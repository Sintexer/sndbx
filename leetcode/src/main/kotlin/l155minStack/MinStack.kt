package l155minStack

import kotlin.math.min

class MinStack() {

    private var head: Node? = null

    fun push(newElement: Int) {
        if (head == null) {
            head = Node(newElement, newElement)
        } else {
            head = Node(newElement, min(newElement, head!!.minValue), head)
        }
    }

    fun pop() {
        head = head!!.next
    }

    fun top(): Int {
        return head!!.value
    }

    fun getMin(): Int {
        return head!!.minValue
    }

    private class Node(
        val value: Int,
        val minValue: Int,
        val next: Node? = null
    )

}

