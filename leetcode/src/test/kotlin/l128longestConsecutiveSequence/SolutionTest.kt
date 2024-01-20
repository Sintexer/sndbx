package l128longestConsecutiveSequence

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {

    private val solution = Solution()

    @Test
    fun longRepeatedAndNegativeTest() {
        val nums = intArrayOf(-6,6,-9,-7,0,3,4,-2,2,-1,9,-9,5,-3,6,1,5,-1,-2,9,-9,-4,-6,-5,6,-1,3)
        assertEquals(14, solution.longestConsecutive(nums))
    }
}