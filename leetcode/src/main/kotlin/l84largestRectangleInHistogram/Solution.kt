package l84largestRectangleInHistogram

import kotlin.math.max

class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var max = 0
        var head: Node? = null
        for (i in heights.indices) {
            val h = heights[i]
            var minPos = -1
            while (head != null && h < head.h) {
                max = max(max, head.h * (i - head.pos))
                minPos = head.pos
                head = head.next
            }
            if (h > 0 && (head == null || h > head.h)) {
                val pos = if (minPos >= 0) minPos else i
                head = Node(h, pos, head)
            }
        }
        while (head != null ) {
            max = max(max, head.h * (heights.size - head.pos))
            head = head.next
        }
        return max
    }
}

data class Node(var h: Int, val pos: Int, var next: Node?)