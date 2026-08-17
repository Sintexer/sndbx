package l543diameterOfBinaryTree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        val result = calculateDiameterRecursive(root)
        return maxOf(result.maxDepth - 1, result.maxDiameter)
    }

    fun calculateDiameterRecursive(root: TreeNode?): Found {
        root ?: return Found(0, 0)

        val l = calculateDiameterRecursive(root.left)
        val r = calculateDiameterRecursive(root.right)

        val diameter = l.maxDepth + r.maxDepth
        return Found(maxOf(l.maxDiameter, r.maxDiameter, diameter), 1 + maxOf(l.maxDepth, r.maxDepth))
    }

    data class Found(val maxDiameter: Int, val maxDepth: Int)
}

class FasterSolution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var diameter = 0
        fun findDepth(root: TreeNode?): Int {
            root ?: return 0

            val l = findDepth(root.left)
            val r = findDepth(root.right)

            diameter = maxOf(diameter, l + r)
            return 1 + maxOf(l, r)
        }
        findDepth(root)
        return diameter
    }

}
