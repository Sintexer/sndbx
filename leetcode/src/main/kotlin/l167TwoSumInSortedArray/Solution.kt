package l167TwoSumInSortedArray

class Solution {
    // [-5, -4, 2, 5, 7, 8, 9, 11, 15, 21, 24] 9
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var l = 0
        var r = numbers.size - 1
        while (l < r) {
            val sum = numbers[l] + numbers[r]
            if (sum == target) return intArrayOf(l + 1, r + 1)
            if (sum > target) {
                --r
            } else {
                ++l
            }
        }
        return intArrayOf()
    }
}
class Solution2 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1

        while (left < right) {
            val sum = numbers[left] + numbers[right]
            when {
                sum == target -> return intArrayOf(left + 1, right + 1)
                sum < target -> ++left
                else -> --right
            }
        }
        return intArrayOf()
    }
}