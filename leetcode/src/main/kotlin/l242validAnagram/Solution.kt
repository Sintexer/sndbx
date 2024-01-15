package l242validAnagram

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false;
        val countS = CharArray(26)
        val countT = CharArray(26)
        for (i in s.indices) {
            ++countS[s[i] - 'a']
            ++countT[t[i] - 'a']
        }
        return countS contentEquals countT
    }
}