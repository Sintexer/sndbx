package l200numberOfIslands

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val visited = Array(rows) { BooleanArray(cols) }
        val queue = ArrayDeque<Pair<Int, Int>>()

        var count = 0
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (visited[i][j]) continue
                if (grid[i][j] == '0') {
                    visited[i][j] = true
                } else {
                    ++count
                    queue.addLast(Pair(i, j))
                    visitIsland(grid, queue, visited, rows, cols)
                }
            }
        }
        return count
    }

    fun visitIsland(grid: Array<CharArray>, queue: ArrayDeque<Pair<Int, Int>>, visited: Array<BooleanArray>, rows: Int, cols: Int) {
        while (queue.isNotEmpty()) {
            val (i, j) = queue.removeLast()
            visited[i][j] = true
            fun tryAddToQueue(row: Int, col: Int) {
                if (visited[row][col]) return
                if (grid[row][col] == '1') queue.addLast(Pair(row, col))
            }
            if (i > 0) tryAddToQueue(i - 1, j)
            if (i < rows - 1) tryAddToQueue(i + 1, j)
            if (j > 0) tryAddToQueue(i, j - 1)
            if (j < cols - 1) tryAddToQueue(i, j + 1)
        }
    }
}

class ModifyingRecursiveSolution {
    fun numIslands(grid: Array<CharArray>): Int {
        val rows = grid.size
        val cols = grid[0].size

        fun traverse(row: Int, col: Int) {
            if (grid[row][col] == '0') return
            grid[row][col] = '0'
            if (row > 0) traverse(row - 1, col)
            if (row < rows - 1) traverse(row + 1, col)
            if (col > 0) traverse(row, col - 1)
            if (col < cols - 1) traverse(row, col + 1)
        }

        var count = 0
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == '1') {
                    ++count
                    traverse(i, j)
                }
            }
        }
        return count
    }
}