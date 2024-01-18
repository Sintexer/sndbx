package l238productOfArrayExceptSelf

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = IntArray(nums.size)
        answer[0] = 1

        val lastIndex = nums.size - 1

        for (i in nums.indices) {
            answer[i + 1] = answer[i] * nums[i]
            if (i == lastIndex - 1) break
        }

        var multi = 1
        for (i in lastIndex downTo 0){
            answer[i] *= multi
            multi *= nums[i]
        }
        return answer
    }
}