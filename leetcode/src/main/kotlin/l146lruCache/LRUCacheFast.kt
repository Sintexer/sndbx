package l146lruCache

//const val MAX_KEY_VALUE = 10_000

class LRUCacheFast(val capacity: Int) {

    val nodes = HashMap<Int, LinkedNode>()

    var size = 0
    var first: LinkedNode? = null
    var last: LinkedNode? = null

    fun get(key: Int): Int {
        val node = remove(key) ?: return -1
        append(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = remove(key)
        if (node == null) {
            if (size == capacity) {
                remove(first?.key ?: -1)
            } else {
                ++size
            }
            append(key, value)
        } else {
            node.value = value
            append(node)
        }
    }

    private fun remove(key: Int): LinkedNode? {
        val node = nodes.remove(key) ?: return null
        val prev = node.prev
        if (prev != null) {
            prev.next = node.next
        } else {
            first = node.next
        }
        val next = node.next
        if (next != null) {
            next.prev = node.prev
        } else {
            last = prev
        }
        return node
    }

    private fun append(key: Int, value: Int) {
        val node = LinkedNode(key, value, null, null)
        append(node)
    }

    private fun append(node: LinkedNode) {
        node.prev = last
        node.next = null
        if (last != null) {
            last!!.next = node
        }
        last = node
        if (first == null) {
            first = node
        }
        nodes[node.key] = node
    }

}

data class LinkedNode(val key: Int, var value: Int, var prev: LinkedNode?, var next: LinkedNode?)

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

