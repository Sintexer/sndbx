package l704binarySearch

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1

        while (l <= r) {
            val mid = l + (r - l) / 2
            val current = nums[mid]
            when {
                current == target -> return mid
                current < target -> l = mid + 1
                else -> r = mid - 1
            }
        }
        return -1
    }
}