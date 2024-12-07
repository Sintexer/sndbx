package l2337movePiecesToObtainAString

class Solution {
    fun canChange(start: String, target: String): Boolean {
        var waitL = 0
        var waitR = 0

        for (i in 0 until start.length) {
            val current = start[i]
            val goal = target[i]
            if (goal == 'L') {
                if (waitR > 0) {
                    return false
                }
                ++waitL
            }
            if (current == 'R') {
                if (waitL > 0) {
                    return false
                }
                ++waitR
            }
            if (goal == 'R') {
                if (waitR == 0) {
                    return false
                }
                --waitR
            }
            if (current == 'L') {
                if (waitL == 0) {
                    return false
                }
                --waitL
            }
        }
        return waitL == 0 && waitR == 0
    }
}