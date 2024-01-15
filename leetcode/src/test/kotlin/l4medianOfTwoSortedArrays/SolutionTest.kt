package l4medianOfTwoSortedArrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {

    private val solution = Solution()

    @Test
    fun testSolution() {
        val median = solution.findMedianSortedArrays(intArrayOf(1, 2, 3, 4, 5, 6), intArrayOf(2, 3, 4, 5, 6, 7, 8))
        // 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8
        assertEquals(4, median)
    }
}