package l567permutationInString


private const val LETTERS = 26

class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val counts = IntArray(LETTERS)

        for (i in s1.indices) {
            counts[getCharCode(s1[i])]--
            counts[getCharCode(s2[i])]++
        }

        val windowSize = s1.length

        var matched = counts.count{ it == 0 }
        if (matched == LETTERS) return true

        for (i in windowSize until s2.length) {
            val rightChar = getCharCode(s2[i])
            val leftChar = getCharCode(s2[i - windowSize])

            // remove old char on the left
            if (counts[leftChar] == 0) --matched
            counts[leftChar]--
            if (counts[leftChar] == 0) ++matched

            // add new char on the right
            if (counts[rightChar] == 0) --matched
            counts[rightChar]++
            if (counts[rightChar] == 0) ++matched

            if (matched == LETTERS) return true
        }
        return false
    }

    fun getCharCode(c: Char) = c - 'a'
}


class ShorterSolution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val counts1 = IntArray(LETTERS)
        val counts2 = IntArray(LETTERS)

        for (i in s1.indices) {
            counts1[getCharCode(s1[i])]++
            counts2[getCharCode(s2[i])]++
        }

        val windowSize = s1.length

        if (counts1.contentEquals(counts2)) return true

        for (i in windowSize until s2.length) {
            val rightChar = getCharCode(s2[i])
            val leftChar = getCharCode(s2[i - windowSize])

            counts2[getCharCode(s2[i])]++
            counts2[getCharCode(s2[i - windowSize])]

            if (counts1.contentEquals(counts2)) return true
        }
        return false
    }

    fun getCharCode(c: Char) = c - 'a'
}

