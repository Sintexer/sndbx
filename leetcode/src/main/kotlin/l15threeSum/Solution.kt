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

class BetterSolution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val answer = mutableListOf<List<Int>>()
        for (i in 0 until nums.size - 2) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i - 1]) continue

            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[left] + nums[right] + nums[i]
                when {
                    sum == 0 -> {
                        answer.add(listOf(nums[i], nums[left], nums[right]))
                        // skip repeated triplets
                        while (left < right && nums[left] == nums[left + 1]) left++
                        while (left < right && nums[right] == nums[right - 1]) right--

                        left++
                        right--
                    }
                    sum < 0 -> ++left
                    else -> --right
                }
            }
        }
        return answer
    }
}