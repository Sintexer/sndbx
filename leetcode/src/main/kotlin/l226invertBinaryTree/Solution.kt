package l226invertBinaryTree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        root ?: return null
        val toProcess = ArrayDeque<TreeNode>(50)

        toProcess.addLast(root)
        while (toProcess.isNotEmpty()) {
            val node = toProcess.removeLast()
            val left = node.left
            val right = node.right
            if (left != null) toProcess.addLast(left)
            if (right != null) toProcess.addLast(right)

            node.left = right
            node.right = left
        }
        return root
    }
}