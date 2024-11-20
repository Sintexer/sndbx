package binarySearch

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class NaiveBinarySearchKtTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    fun testBinarySliceSearch(array: IntArray, target: Int, expected: Pair<Int, Int>?) {
        assertEquals(expected, binarySliceSearch(array, target))
    }

    companion object {

        private val NOT_FOUND_PAIR = Pair(-1, -1)

        @JvmStatic
        fun provideTestCases() = listOf(
            Arguments.of(intArrayOf(1, 1, 1, 1, 3, 3, 4, 5, 6, 7), 1, Pair(0, 4)),
            Arguments.of(intArrayOf(1, 1, 1, 1, 3, 3, 4, 5, 6, 7), 3, Pair(4, 6)),
            Arguments.of(intArrayOf(1, 1, 1, 1, 3, 3, 4, 5, 6, 7), 7, Pair(9, 10)),
            Arguments.of(intArrayOf(1, 1, 1, 1, 3, 3, 4, 5, 6, 7), 2, NOT_FOUND_PAIR),
            Arguments.of(intArrayOf(1), 1, Pair(0, 1)),
            Arguments.of(intArrayOf(1), 2, NOT_FOUND_PAIR),
            Arguments.of(intArrayOf(), 1, NOT_FOUND_PAIR),
            Arguments.of(intArrayOf(1, 2, 2, 2, 3, 4), 2, Pair(1, 4)),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5), 3, Pair(2, 3)),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5), 6, NOT_FOUND_PAIR)
        )
    }
}