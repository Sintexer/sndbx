package l42trappingRainWater

import kotlin.math.min

class Solution {
    fun trap(height: IntArray): Int {
        var maxLeft = 0
        var maxRight = 0
        var result = 0

        var l = 0
        var r = height.size - 1
        while (l <= r) {
            val left = height[l]
            val right = height[r]

            if (left >= maxLeft) {
                maxLeft = left
                ++l
                continue
            }
            if (right >= maxRight) {
                maxRight = right
                --r
                continue
            }
            val bound = min(maxLeft, maxRight)

            val i = if (maxLeft < maxRight) l else r
            val currentHeight = bound - height[i]
            result += currentHeight
            if (maxLeft < maxRight) {
                ++l
            } else {
                --r
            }
        }
        return result
    }

}