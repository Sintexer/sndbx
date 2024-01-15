package l347topKFrequentElement

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {

    private val solution = FasterSolution()

    @Test
    fun topKFrequentElementTest() {
        val result = solution.topKFrequent(intArrayOf(1, 1, 1, 2, 3, 3), 2)
        assertEquals(2, result.size)
        assertEquals(setOf(1, 3), result.toSet())
    }

    @Test
    fun topKFrequentElementWithNegativesTest() {
        val result = solution.topKFrequent(intArrayOf(
            -10_000, -10_000,
            -9_999, -9_999,
            -1, -1, -1, -1,
            0, 0,
            1,
            2,
            3,
            4, 4, 4,
            10_000, 10_000, 10_000
        ), 6)
        assertEquals(6, result.size)
        assertEquals(setOf(-10_000, -9_999, -1, 0, 4, 10_000), result.toSet())
    }
}