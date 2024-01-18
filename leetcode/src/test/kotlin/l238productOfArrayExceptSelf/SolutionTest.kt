package l238productOfArrayExceptSelf

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    private val solution = Solution()

    @Test
    fun productExceptSelf() {
        assertSolution(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(24, 12, 8, 6)
        )
    }

    @Test
    fun zeroElementTest() {
        assertSolution(
            intArrayOf(1, 0, 3, 4),
            intArrayOf(0, 12, 0, 0)
        )
    }

    @Test
    fun repeatedElementsTest() {
        assertSolution(
            intArrayOf(-1, 1, -1, 1, -1),
            intArrayOf(1, -1, 1, -1, 1)
        )
    }

    private fun assertSolution(source: IntArray, expected: IntArray, ) {
        val actual = solution.productExceptSelf(source)
        assertArrayEquals(expected, actual)
    }
}