package l153findMinimumInRotatedSortedArray

class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1

        while (l < r) {
            val mid = l + (r - l) / 2
            val current = nums[mid]


            if (current >= nums[r]) {
                l = mid + 1
            } else {
                r = mid
            }
        }
        return nums[r]
    }
}