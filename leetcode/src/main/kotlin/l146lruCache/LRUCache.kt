package l146lruCache

import kotlin.math.min

const val MAX_KEY_VALUE = 10_000

class LRUCache(val capacity: Int) {
    val elements = Array<Pair<Int, Int>?>(MAX_KEY_VALUE) { null }
    val keyToPriority = HashMap<Int, Int>()
    val priorityToKey = HashMap<Int, Int>()
    var currentPriority = 0
    var minPriority = 0
    var size = 0

    fun get(key: Int): Int {
        val (value, priority) = elements[key] ?: return -1
        refreshValue(priority, key, value)
        return value
    }

    fun put(key: Int, value: Int) {
        val pair = elements[key]
        if (pair != null) {
            val (_, priority) = pair
            refreshValue(priority, key, value)
            return
        }

        if (size == capacity) {
            val minPriority = priorityToKey.keys.minOrNull() ?: return
            val removedKey = priorityToKey.remove(minPriority)
            if (removedKey != null) {
                elements[removedKey] = null
                keyToPriority.remove(removedKey)
            }
            updateMinPriority()
        } else {
            ++size
        }

        updateKeyPriority(key, value)
    }

    private fun refreshValue(priority: Int, key: Int, value: Int) {
        priorityToKey.remove(priority)
        updateKeyPriority(key, value)
    }

    private fun updateKeyPriority(key: Int, value: Int) {
        elements[key] = Pair(value, currentPriority)
        priorityToKey[currentPriority] = key
        keyToPriority[key] = currentPriority
        if (currentPriority == minPriority) {
            updateMinPriority()
        }
        ++currentPriority
    }

    private fun updateMinPriority() {
        while (!priorityToKey.containsKey(minPriority) && minPriority < currentPriority) {
            ++minPriority
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

