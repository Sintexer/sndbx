package l74searchA2dMatrix

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        var l = 0
        var r = matrix.size - 1
        while (l < r) {
            val mid = (r + l + 1) / 2
            val current = matrix[mid]
            if (target < current[0]) r = mid - 1
            else l = mid
        }
        val targetArray = matrix[r]

        l = 0
        r = targetArray.size - 1

        while (l <= r) {
            val mid = l + (r - l) / 2
            val current = targetArray[mid]
            if (target < current) r = mid - 1
            else if (target > current) l = mid + 1
            else return true
        }
        return false
    }
}