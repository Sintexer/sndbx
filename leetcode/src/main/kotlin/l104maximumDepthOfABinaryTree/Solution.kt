package l104maximumDepthOfABinaryTree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        root ?: return 0
        val maxDepth = maxOf(maxDepth(root.left), maxDepth(root.right))
        return 1 + maxDepth
    }
}