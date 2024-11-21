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