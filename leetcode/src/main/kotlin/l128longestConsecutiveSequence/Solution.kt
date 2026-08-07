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

class FasterSolution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val counts = hashMapOf<Int, Int>()
        var maxLength = 0
        for (num in nums) {
            if (counts[num] != null) continue
            counts[num] = num
            val left = counts[num - 1]
            val right = counts[num + 1]
            if (left == null && right == null) continue
            if (left != null && right != null) {
                counts[left] = right
                counts[right] = left
                maxLength = max(maxLength, right - left)
            } else if (right != null) {
                counts[num] = right
                counts[right] = num
                maxLength = max(maxLength, right - num)
            } else if (left != null) {
                counts[num] = left
                counts[left] = num
                maxLength = max(maxLength, num - left)
            }
        }
        return maxLength + 1
    }
}

class SimpleYetSlowSolution {
    fun longestConsecutive(nums: IntArray): Int {
        val unique = nums.toHashSet()
        var longest = 0

        for (num in nums) {
            if (unique.contains(num - 1)) continue
            var next = num + 1
            while (unique.contains(next)) {
                ++next
            }
            longest = max(longest, next - num)

        }
        return longest
    }
}