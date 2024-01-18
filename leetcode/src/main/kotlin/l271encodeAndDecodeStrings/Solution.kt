package l271encodeAndDecodeStrings

import java.util.LinkedList

/**
 * WRONG AND UNFINISHED SOLUTION
 */
class Solution {

    fun encode(strs: List<String>): String {
        val result = StringBuilder()
        for (i in strs.indices) {
            result.append(strs[i].replace(delim, substitution))
            if (i < strs.size - 1) {
                result.append(delimChar)
            }
        }
        return result.toString()
    }

    fun decode(str: String): List<String> {
        val answer: MutableList<String> = LinkedList()
        var i = 0
        val current = StringBuilder()
        while (i < str.length) {
            val next = str.indexOf(delimChar, i)
            if (next == -1) {
                current.append(str, i, str.length)
                answer.add(current.toString())
                return answer
            } else if (str[i + 1] == delimChar) {
                current.append(str, i, next + 1)
                i = next + 1
            } else {
                current.append(str, i, next)
                answer.add(current.toString())
                current.setLength(0)
                i = next
            }
        }
        return answer
    }

    companion object {
        private const val delim = "\\|"
        private const val delimChar = '|'
        private const val substitution = "||"
    }
}