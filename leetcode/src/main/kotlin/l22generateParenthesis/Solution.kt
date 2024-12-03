package l22generateParenthesis

class Solution {
    // stack solution
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()

        var head: Node? = Node("(", n - 1, 1, null)

        while (head != null) {
            val node = head
            head = head.next

            if (node.openLeft == 0 && node.closeLeft == 0) {
                result.add(node.brackets)
                continue
            }

            if (node.openLeft > 0) {
                head = Node(node.brackets + "(", node.openLeft - 1, node.closeLeft + 1, head)
            }
            if (node.closeLeft > 0) {
                head = Node(node.brackets + ")", node.openLeft, node.closeLeft - 1, head)
            }
        }
        return result
    }

    // 2nd faster solution, recursive
    fun generateParenthesisRecursive(n: Int): List<String> {
        val result = mutableListOf<String>()
        nextStep(result, n, 0, "")
        return result
    }

    fun nextStep(result: MutableList<String>, open: Int, close: Int, current: String) {
        if (open == 0 && close == 0) {
            result.add(current)
            return
        }

        if (open > 0) {
            nextStep(result, open - 1, close + 1, current + "(")
        }
        if (close > 0) {
            nextStep(result, open, close -1, current + ")")
        }
    }
}

data class Node(val brackets: String, val openLeft: Int, val closeLeft: Int, var next: Node?)