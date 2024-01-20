package l128longestConsecutiveSequence

import kotlin.math.abs
import kotlin.math.max

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (n in nums) {
            if (map.contains(n)) {
                continue
            }
            val high = map[n + 1]
            val low = map[n - 1]
            if (high != null && low != null) {
                map[low] = high
                map[high] = low
                map[n] = n
            } else if (high != null) {
                map[n] = high
                map[high] = n
            } else if (low != null) {
                map[n] = low
                map[low] = n
            } else {
                map[n] = n
            }
        }
        var answer = 0
        for ((k, v) in map) {
            answer = max(abs(v - k) + 1, answer)
        }
        return answer
    }
}