class Solution {
    fun minWindow(s: String, t: String): String {
        if (s.length < t.length) return ""
        val counts = IntArray(128)
        var left = 0
        var right = 0
        var remainingNeeded = t.length
        for (char in t) {
            counts[char.code]++
        }
        var minLength = Int.MAX_VALUE
        var bestStart = 0 // bestStart + minLength == target substring
        for (right in s.indices) {
            val newCode = s[right].code
            if (counts[newCode] > 0) {
                --remainingNeeded
            }
            counts[newCode]--
            
            while (remainingNeeded == 0) {
                if (right - left + 1 < minLength) {
                    bestStart = left
                    minLength = right - left + 1
                }
                val removedCode = s[left].code
                if (counts[removedCode] == 0) {
                    ++remainingNeeded
                }
                counts[removedCode]++
                ++left
            }
        }
        if (minLength == Int.MAX_VALUE) return ""
        return s.substring(bestStart, bestStart + minLength)
    }
}

