package l4medianOfTwoSortedArrays

import kotlin.math.log2

class Solution {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val n = nums1.size
        val m = nums2.size
        val N = m + n
        val steps = log2(N.toDouble()).toInt()

        var i: Int = n/2
        var j: Int = n/2
        for(k in 0..steps) {
            val nVal = nums1[i]
            val mVal = nums2[j]

//            if (nVal > mVal) {
//
//            } else {
//                if (mVal > )
//            }
        }
        return .0
    }
}