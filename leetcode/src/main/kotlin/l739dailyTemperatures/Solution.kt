package l739dailyTemperatures

class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size){0}
        var head: Node? = null
        for ((i, temp) in temperatures.withIndex()) {
            while (head != null && head.temp < temp) {
                val node = head
                head = head.next
                result[node.index] = i - node.index
            }
            head = Node(temp, i, head)
        }
        return result
    }
}

data class Node(val temp: Int, val index: Int, val next: Node?)