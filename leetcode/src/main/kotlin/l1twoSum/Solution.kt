package l1twoSum

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for(i in nums.indices) {
            val subtraction = target - nums[i]
            if (map.contains(subtraction)) {
                return intArrayOf(map[subtraction]!!, i)
            } else {
                map[nums[i]] = i
            }
        }
        return intArrayOf()
    }
}