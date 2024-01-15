package l217containsDuplicate

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val uniqueValues = HashSet<Int>();
        for (i in nums.indices) {
            if (uniqueValues.contains(nums[i])) {
                return true;
            } else {
                uniqueValues.add(nums[i]);
            }
        }
        return false;
    }
}