package l110balancedBinaryTree

import kotlin.math.abs

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        var balanced = true
        fun dfs(node: TreeNode?): Int {
            node ?: return 0
            if (!balanced) return 0
            val left = dfs(node.left)
            val right = dfs(node.right)
            balanced = balanced && (abs(left - right) <= 1)
            return 1 + maxOf(left, right)
        }
        dfs(root)
        return balanced
    }
}

class FasterSolution {
    fun isBalanced(root: TreeNode?): Boolean {
        fun dfs(node: TreeNode?): Int {
            node ?: return 0
            val left = dfs(node.left)
            if (left == -1) return -1
            val right = dfs(node.right)
            if (right == -1) return -1
            if (abs(left - right) > 1) return -1
            return 1 + maxOf(left, right)
        }
        return dfs(root) != -1
    }
}