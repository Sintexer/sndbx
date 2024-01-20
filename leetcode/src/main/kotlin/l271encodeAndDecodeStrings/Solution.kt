package l271encodeAndDecodeStrings

import java.util.LinkedList

class Solution {

    fun encode(strs: List<String>): String {
        val result = StringBuilder()
        for (i in strs.indices) {
            result.append(strs[i].replace(FORBIDDEN_SEQUENCE, REPLACED))
            result.append(DELIM)
        }
        return result.toString()
    }

    fun decode(str: String): List<String> {
        if (str == DELIM) {
            return listOf("")
        }
        val answer: MutableList<String> = LinkedList()
        for (s in str.split(DELIM)) {
            answer.add(s.replace(REPLACED, FORBIDDEN_SEQUENCE))
        }
        return answer
    }

    companion object {
        private const val DELIM = "~|~"
        private const val FORBIDDEN_SEQUENCE = "~|"
        private const val REPLACED = "~||"
    }
}