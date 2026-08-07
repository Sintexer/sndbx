package l11containerWithMostWater

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxArea(height: IntArray): Int {
        var maxL = -1
        var maxR = -1
        var maxArea = 0

        var l = 0
        var r = height.size - 1

        while (l < r) {
            val leftBound = height[l]
            val rightBound = height[r]
            if (leftBound < maxL) {
                ++l
                continue
            }
            if (rightBound < maxR) {
                --r
                continue
            }

            val area = min(leftBound, rightBound) * (r - l)
            maxArea = max(maxArea, area)
            maxL = max(maxL, leftBound)
            maxR = max(maxR, rightBound)

            if (leftBound < rightBound) {
                ++l
            } else {
                --r
            }
        }
        return maxArea
    }
}


class FasterSolution {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size - 1
        var maxArea = 0

        while (left < right) {
            val currentMin = minOf(heights[left], heights[right])
            val area = currentMin * (right - left)
            maxArea = maxOf(maxArea, area)
            // Skip any bar on the left that is <= the limiting height
            while (left < right && heights[left] <= currentMin) {
                left++
            }
            // Skip any bar on the right that is <= the limiting height
            while (left < right && heights[right] <= currentMin) {
                right--
            }
        }
        return maxArea
    }
}