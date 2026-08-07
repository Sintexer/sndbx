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


class BetterSolution {

    companion object {
        const val DELIM = '#'
    }

    fun encode(strs: List<String>): String {
        return strs.map(this::encode).joinToString("")
    }

    fun encode(str: String): String = "" + str.length + DELIM + str

    fun decode(str: String): List<String> {
        val result = mutableListOf<String>()

        var index = 0
        val builder = StringBuilder()
        while (index < str.length) {
            val numberStart = index
            while (str[index] != DELIM) ++index
            val length = str.substring(numberStart, index).toInt()
            ++index
            builder.clear()
            if (length > 0) {
                val stringStart = index
                index += length
                builder.append(str, stringStart, index)
            }
            result.add(builder.toString())
        }
        return result
    }
}