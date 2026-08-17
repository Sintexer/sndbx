package l424longestRepeatingCharacterReplacement

class Solution {

    fun characterReplacement(s: String, k: Int): Int {
        val charCount = IntArray(26) { 0 }

        var left = 0
        var right = 0
        var maxSubstringLength = 0


        while (right < s.length) {
            ++right
            val charCode = (s[right - 1] - 'A')
            charCount[charCode] = charCount[charCode] + 1
            var popularCharCount = charCount.max()
            var length = right - left
            if (length - popularCharCount <= k) {
                maxSubstringLength = maxOf(maxSubstringLength, length)
            }
            while (length - popularCharCount > k) {
                val removedCharCode = s[left] - 'A'
                ++left
                charCount[removedCharCode] = charCount[removedCharCode] - 1
                popularCharCount = charCount.max()
                length = right - left
            }
        }
        return maxSubstringLength
    }

}

class FasterSolution {

    fun characterReplacement(s: String, k: Int): Int {
        val charCount = IntArray(26) { 0 }

        var left = 0
        var right = 0
        var maxSubstringLength = 0

        var popularCharCount = 0
        while (right < s.length) {
            ++right
            val charCode = (s[right - 1] - 'A')
            val newCount = charCount[charCode] + 1
            charCount[charCode] = newCount

            // substring length is: popularCharCount + k = substringLength
            // k is constant, so our substring length grows only if popularCharCount grows
            // so no need to check the case when popular char count decreases
            popularCharCount = maxOf(popularCharCount, newCount)
            var length = right - left
            if (length - popularCharCount <= k) {
                maxSubstringLength = maxOf(maxSubstringLength, length)
            }
            while (length - popularCharCount > k) {
                val removedCharCode = s[left] - 'A'
                ++left
                charCount[removedCharCode] = charCount[removedCharCode] - 1
                length = right - left
            }
        }
        return maxSubstringLength
    }

}
