package l36validSudoku

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val colSet = HashSet<Char>()
        val rowSet = HashSet<Char>()
        val blockSet = HashSet<Char>()
        for (i in 0 until 9) {


            for (j in 0 until 9) {
                val c = board[i][j]
                val r = board[j][i]

                if (r != '.' && !rowSet.add(r)) {
                    return false
                }
                if (c != '.' && !colSet.add(c)) {
                    return false
                }

                val br = ((i/3) * 3) + j/3
                val bc = ((i%3) * 3) + j%3
                val b = board[br][bc]
                if (b != '.' && !blockSet.add(b)) {
                    return false
                }
            }
            rowSet.clear()
            colSet.clear()
            blockSet.clear()
        }
        return true
    }
}

class AnotherSolution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { BooleanArray(10) }
        val cols = Array(9) { BooleanArray(10) }
        val boxes = Array(9) { BooleanArray(10) }

        for (i in board.indices) {
            val row = board[i]
            for (j in row.indices) {
                val char = row[j]
                if (isEmpty(char)) continue
                val box = getBoxIndex(i, j)
                val digit = char - '0'
                if (rows[i][digit] || cols[j][digit] || boxes[box][digit]) {
                    return false
                }
                rows[i][digit] = true
                cols[j][digit] = true
                boxes[box][digit] = true
            }
        }
        return true
    }

    private fun isEmpty(char: Char): Boolean = char == EMPTY_CELL

    fun getBoxIndex(i: Int, j: Int) = (i / 3) * 3 + (j / 3)

    companion object {
        private const val EMPTY_CELL = '.'
    }
}