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