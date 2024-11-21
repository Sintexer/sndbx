package l371sumOfTwoIntegersWithoutPlus

class Solution {
    fun getSum(a: Int, b:Int): Int {
        if (a == 0) return b
        if (b == 0) return a

        var result = a
        var carry = b

        while (carry != 0) {
            val sameBits = result and carry
            result = result xor carry
            carry = sameBits shl 1
        }
        return result
    }
}