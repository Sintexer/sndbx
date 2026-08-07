package l3longestSubsctringWithoutRepeating

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {

        val seenChars = IntArray(128)
        var maxLength = 0
        var left = 0
        for (right in s.indices) {
            val charCode = s[right].code
            left = maxOf(left, seenChars[charCode])
            maxLength = maxOf(maxLength, right - left + 1)
            seenChars[charCode] = right + 1 // store +1 so 0 means never seen
        }

        return maxLength
    }
}
