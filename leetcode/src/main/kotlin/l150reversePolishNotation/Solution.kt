package l150reversePolishNotation

class Solution {

    private var head: Node? = null

    fun evalRPN(tokens: Array<String>): Int {
        for (token in tokens) {
            if (isOperator(token)) {
                val right = pop()
                val left = pop()
                val result = when (token) {
                    "+" -> left + right
                    "-" -> left - right
                    "/" -> left / right
                    "*" -> left * right
                    else -> throw IllegalStateException()
                }
                push(result)
            } else {
                push(token.toInt())
            }
        }
        return pop()
    }

    private fun push(number: Int) {
        head = Node(number, head)
    }

    private fun pop(): Int {
        val number = head!!.number
        head = head!!.next
        return number
    }

    private fun isOperator(token: String): Boolean {
        return token.length == 1 &&
                ("+" == token
                        || "-" == token
                        || "/" == token
                        || "*" == token)
    }
}

data class Node(val number: Int, var next: Node?)