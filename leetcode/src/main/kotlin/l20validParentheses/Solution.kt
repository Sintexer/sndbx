package l20validParentheses

class Solution {

    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        for (char in s) {
            if (isOpening(char)) {
                stack.addLast(getOppositeBracket(char))
            } else if (stack.isEmpty() || stack.removeLast() != char) {
                return false
            }
        }
        return stack.isEmpty()
    }

    private fun isOpening(bracket: Char): Boolean = bracket == '(' || bracket == '[' || bracket == '{'

    private fun getOppositeBracket(bracket: Char): Char {
        return if (bracket == '(') {
            ')'
        } else if (bracket == '[') {
            ']'
        } else {
            '}'
        }
    }
}