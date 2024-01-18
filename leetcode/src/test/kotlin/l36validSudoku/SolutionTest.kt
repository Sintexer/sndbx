package l36validSudoku

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun isValidSudoku() {
        val input = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )

        val answer = Solution().isValidSudoku(input)
        assertTrue(answer)
    }

    @Test
    fun isInvalidSudoku() {
        val board = arrayOf(
            charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
        assertFalse(Solution().isValidSudoku(board))
    }

    @Test
    fun isInvalidSudoku2() {
        val board = arrayOf(
            charArrayOf('.', '.', '4', '.', '.', '.', '6', '3', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('5', '.', '.', '.', '.', '.', '.', '9', '.'),
            charArrayOf('.', '.', '.', '5', '6', '.', '.', '.', '.'),
            charArrayOf('4', '.', '3', '.', '.', '.', '.', '.', '1'),
            charArrayOf('.', '.', '.', '7', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '5', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.')
        )
        assertFalse(Solution().isValidSudoku(board))
    }

    @Test
    fun isValidSudoku2() {
        val board = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
        assertTrue(Solution().isValidSudoku(board))
    }

    @Test
    fun isInvalidSudoku4() {
        val board = arrayOf(
            charArrayOf('.', '.', '4', '.', '.', '.', '6', '3', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('5', '.', '.', '.', '.', '.', '.', '9', '.'),
            charArrayOf('.', '.', '.', '5', '6', '.', '.', '.', '.'),
            charArrayOf('4', '.', '3', '.', '.', '.', '.', '.', '1'),
            charArrayOf('.', '.', '.', '7', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '5', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.')
        )
        assertFalse(Solution().isValidSudoku(board))
    }

}