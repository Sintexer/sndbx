package l15threeSum

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        nums.sort()

        for (i in nums.indices) {
            val current = nums[i]
            // skip duplicates
            if (i > 0 && nums[i-1] == current) {
                continue
            }
            var l = i + 1
            var r = nums.size - 1
            // two pointers in a sorted array to find target sum
            val target = -current
            while (l < r) {
                val left = nums[l]
                val right = nums[r]
                // skip duplicates
                if (l > i + 1 && left == nums[l - 1]) {
                    ++l
                    continue
                } else if (r < nums.size - 1 && right == nums[r + 1]) {
                    --r
                    continue
                }

                val sum = left + right
                if (sum == target) {
                    result.add(listOf(current, left, right))
                    ++l
                } else if (sum < target) {
                    ++l
                } else {
                    --r
                }
            }
        }

        return result
    }
}